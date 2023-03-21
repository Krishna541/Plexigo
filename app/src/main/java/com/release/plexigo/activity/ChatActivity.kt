package com.release.plexigo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.TimeoutError
import com.android.volley.toolbox.Volley
import com.release.plexigo.Common.CustomProgressDialog
import com.release.plexigo.Constants.AppConstants
import com.release.plexigo.R
import com.release.plexigo.adapter.ChatAdapter
import com.release.plexigo.models.ChatModel
import com.release.plexigo.models.CreateSendBirdUserrequest
import com.release.plexigo.network.APIClient
import com.release.plexigo.network.APIInterface
import com.sendbird.android.BaseChannel
import com.sendbird.android.OpenChannel
import com.sendbird.android.SendBird
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.util.*

class ChatActivity : AppCompatActivity() {
    var openChannelObject: OpenChannel? = null
    var queue: RequestQueue? = null
    private val CHECKUSEREXISTAPI =
        "https://api-4356dbe1-58e9-4ff0-9035-ac7e47bf7a68.sendbird.com/v3/users"
    var CHANNEL_URL: String? = null

    //    String userid;
    var all_chats: ArrayList<ChatModel>? = null
    var adapter: ChatAdapter? = null
    lateinit var apiInterface : APIInterface
    private val CHAT_API_TOKEN = "d8e5f0094ae84ae78e797868d07f5deceb5bf429"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        queue = Volley.newRequestQueue(this@ChatActivity)
        message.requestFocus()
        all_chats = ArrayList()
        apiInterface = APIClient.getClient("").create(APIInterface::class.java)
        CHANNEL_URL = intent.getStringExtra("channel_url")
        if (CHANNEL_URL == null) {
            Toast.makeText(this, "No Channel url found!", Toast.LENGTH_SHORT).show()
            return
        }

//        CHANNEL_URL = "sendbird_open_channel_9369_09bc17497c131f90cda0ca6aad5441266337c465";
//        userid = "GanuP";
//        AppConstants.username = "GanuP";
        send.setOnClickListener(View.OnClickListener {
            if (message.getText().toString().trim { it <= ' ' }.isEmpty()) {
                Toast.makeText(this@ChatActivity, "Please enter message", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val cal = Calendar.getInstance()
            val hour = cal[Calendar.HOUR]
            val minute = cal[Calendar.MINUTE]
            val msg = message.getText().toString().trim { it <= ' ' }
            val model = ChatModel(msg, "$hour:$minute")
            model.message = msg
            model.timestring = "$hour:$minute"
            all_chats!!.add(model)
            if (adapter == null) {
                val LayoutManager =
                    LinearLayoutManager(this@ChatActivity, RecyclerView.VERTICAL, false)
                LayoutManager.stackFromEnd = true
                adapter = ChatAdapter(this@ChatActivity, all_chats!!)
                chatwindow.layoutManager = LayoutManager
                chatwindow.adapter = adapter
            } else {
                adapter!!.notifyDataSetChanged()
            }
            message.setText("")
            if (openChannelObject != null) {
                openChannelObject!!.sendUserMessage(msg,
                    BaseChannel.SendUserMessageHandler { userMessage, e ->
                        if (e != null) {    // Error.
                            return@SendUserMessageHandler
                        }

                        // success
                    })
            }
        })
        CheckUserIsExist()
    }

    fun initSendBird(access_token: String?) {
        // Connect to sendbird server
        SendBird.connect(
            AppConstants.UserId, access_token,
            SendBird.ConnectHandler { user, e ->
                if (e != null) {    // Error.
                    return@ConnectHandler
                }
            })

        //Enter in a channel
        OpenChannel.getChannel(CHANNEL_URL,
            OpenChannel.OpenChannelGetHandler { openChannel, e ->
                if (e != null) {    // Error.
                    return@OpenChannelGetHandler
                }
                openChannel.enter(OpenChannel.OpenChannelEnterHandler { e ->
                    if (e != null) {    // Error.
                        return@OpenChannelEnterHandler
                    }
                })
                openChannelObject = openChannel
            })
    }

    private fun CheckUserIsExist() {
        Showloader()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.checkUserExist(AppConstants.UserId!!)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val json = JSONObject(response.body()!!.toString())
                        if (json.has("user_id") && json.getString("user_id") != null) {
                            if (json.has("access_token") && !json.getString("access_token")
                                    .isEmpty()
                            ) {
                                val access_token = json.getString("access_token")
                                initSendBird(access_token)
                            } else {
                                Toast.makeText(
                                    this@ChatActivity,
                                    "No access token found ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else if (json.has("code") && json.getInt("code") == 400201) {  //user not founc
                            CreateSendbirdUser()
                        } else {
                            if (json.has("message") && json.getString("message") != null) {
                                Toast.makeText(
                                    this@ChatActivity,
                                    "chat " + json.getString("message"),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ChatActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (e: Throwable) {
                    HideLoader()
                    CreateSendbirdUser()
                }
            }
        }
    }

    fun CreateSendbirdUser() {
        Showloader()
        val request = CreateSendBirdUserrequest(AppConstants.UserId!!,AppConstants.username!!,true,"")
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiInterface.createSendbirdUser(request)
            withContext(Dispatchers.Main) {
                try {
                    HideLoader()
                    if (response.isSuccessful) {
                        val json = JSONObject(response.body()!!.toString())
                        if (json.has("user_id") && !json.getString("user_id")
                                .isEmpty()
                        ) {
                            if (json.has("access_token") && !json.getString("access_token")
                                    .isEmpty()
                            ) {
                                val access_token = json.getString("access_token")
                                initSendBird(access_token)
                            } else {
                                Toast.makeText(
                                    this@ChatActivity,
                                    "No access token found ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else if (json.has("code") && json.getInt("code") == 400202) {  //already there
                            //                                CreateSendbirdUser();
                        } else {
                            if (json.has("message") && json.getString("message") != null) {
                                Toast.makeText(
                                    this@ChatActivity,
                                    "chat " + json.getString("message"),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@ChatActivity, "${e.message}", Toast.LENGTH_SHORT)
                        .show()
                } catch (error: Throwable) {
                    HideLoader()
                    if (error is TimeoutError) {
                        Toast.makeText(
                            this@ChatActivity,
                            R.string.timeout_message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    if (error.cause is IOException) {
                        Toast.makeText(
                            this@ChatActivity,
                            getString(R.string.internet_not_available),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Toast.makeText(
                        this@ChatActivity,
                        "Error in creating chat user" + error.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun Showloader() {
        customProgressDialog = CustomProgressDialog.newInstance()
        val ft = supportFragmentManager.beginTransaction()
        customProgressDialog.show(ft, "dialog")
        customProgressDialog.isCancelable = false
    }

    fun HideLoader() {
        if (customProgressDialog != null) customProgressDialog.dismiss()
    }

    companion object {
        lateinit var customProgressDialog: CustomProgressDialog
    }
}
