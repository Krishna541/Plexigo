package com.release.plexigo.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bs\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00f3\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u0005j\b\u0012\u0004\u0012\u00020!`\u0007\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0#\u0012\u0006\u0010\'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\f\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u0002010#\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\f\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010:\u001a\u00020\u0003\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010<\u001a\u00020\u0001\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010?J\t\u0010p\u001a\u00020\u0003H\u00c6\u0003J\t\u0010q\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\t\u0010t\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\t\u0010v\u001a\u00020\u0003H\u00c6\u0003J\t\u0010w\u001a\u00020\u0003H\u00c6\u0003J\t\u0010x\u001a\u00020\u0003H\u00c6\u0003J\t\u0010y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010z\u001a\u00020\u0003H\u00c6\u0003J\u0019\u0010{\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u00c6\u0003J\t\u0010|\u001a\u00020\u0003H\u00c6\u0003J\t\u0010}\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003H\u00c6\u0003J\u001a\u0010\u0082\u0001\u001a\u0012\u0012\u0004\u0012\u00020!0\u0005j\b\u0012\u0004\u0012\u00020!`\u0007H\u00c6\u0003J\u0010\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020$0#H\u00c6\u0003J\u0010\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020&0#H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\fH\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u0002010#H\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\fH\u00c6\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u00020\fH\u00c6\u0003J\n\u0010\u00a0\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a2\u0001\u001a\u00020\u0001H\u00c6\u0003J\u00cc\u0004\u0010\u00a3\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\u0018\b\u0002\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u0005j\b\u0012\u0004\u0012\u00020!`\u00072\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0#2\b\b\u0002\u0010\'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\f2\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u0002010#2\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\f2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010:\u001a\u00020\u00032\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010<\u001a\u00020\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0016\u0010\u00a4\u0001\u001a\u00030\u00a5\u00012\t\u0010\u00a6\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u00a7\u0001\u001a\u00020\fH\u00d6\u0001J\n\u0010\u00a8\u0001\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010AR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010AR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010AR\u0013\u0010>\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010AR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010AR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010AR\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010AR\u0011\u0010\u000f\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010AR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010MR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010MR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010AR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010MR\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010AR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010AR\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010AR\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010AR\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010AR\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010AR\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010AR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010MR\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010AR\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010AR\u0011\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010AR!\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u0005j\b\u0012\u0004\u0012\u00020!`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010CR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0#\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010XR\u0011\u0010\'\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010AR\u0011\u0010(\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010AR\u0011\u0010)\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010AR\u0011\u0010*\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010AR\u0011\u0010+\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010AR\u0011\u0010,\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010IR\u0011\u0010-\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010AR\u0011\u0010.\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010AR\u0011\u0010/\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010AR\u0017\u00100\u001a\b\u0012\u0004\u0012\u0002010#\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010XR\u0011\u00102\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010AR\u0011\u00103\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010AR\u0011\u00104\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010AR\u0011\u00105\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010AR\u0013\u0010=\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u0010AR\u0013\u00106\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010MR\u0011\u00107\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u0010AR\u0011\u00108\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\bk\u0010IR\u0013\u00109\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010MR\u0011\u0010:\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010AR\u0013\u0010;\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bn\u0010MR\u0011\u0010<\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010M\u00a8\u0006\u00a9\u0001"}, d2 = {"Lcom/release/plexigo/models/Contentdetail;", "", "blockMessage", "", "castCrew", "Ljava/util/ArrayList;", "Lcom/release/plexigo/models/CastModel;", "Lkotlin/collections/ArrayList;", "censorrating", "channelID", "contentType", "contentid", "", "contentname", "country", "dashURL", "duration", "fairplayCertificateURL", "fairplayLicenseURL", "genere", "hlsURL", "imagepath", "inr", "isBrowserBlock", "isDRMContent", "isFavourite", "isFilmFestival", "isLive", "isLiveDRM", "isQnAEnabled", "isWatchLater", "language", "languages", "Lcom/release/plexigo/models/LanguageModel;", "ottPlatforms", "", "Lcom/release/plexigo/models/OTTModel;", "paymentGateway", "Lcom/release/plexigo/models/PaymentGateway;", "pollInterval", "posterpath", "ppv", "ppvTitle", "ppvType", "ppvValidity", "rating", "releaseyear", "rentValidity", "seasons", "Lcom/release/plexigo/models/TvSeriesSeasons;", "showLikes", "synopsis", "tacLink", "tacText", "trailerpath", "usd", "userLikes", "videopath", "watchDuration", "wideimgepath", "widevineLicenseURL", "thumbnailText", "contentExpiryTime", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "getBlockMessage", "()Ljava/lang/String;", "getCastCrew", "()Ljava/util/ArrayList;", "getCensorrating", "getChannelID", "getContentExpiryTime", "getContentType", "getContentid", "()I", "getContentname", "getCountry", "getDashURL", "()Ljava/lang/Object;", "getDuration", "getFairplayCertificateURL", "getFairplayLicenseURL", "getGenere", "getHlsURL", "getImagepath", "getInr", "getLanguage", "getLanguages", "getOttPlatforms", "()Ljava/util/List;", "getPaymentGateway", "getPollInterval", "getPosterpath", "getPpv", "getPpvTitle", "getPpvType", "getPpvValidity", "getRating", "getReleaseyear", "getRentValidity", "getSeasons", "getShowLikes", "getSynopsis", "getTacLink", "getTacText", "getThumbnailText", "getTrailerpath", "getUsd", "getUserLikes", "getVideopath", "getWatchDuration", "getWideimgepath", "getWidevineLicenseURL", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Contentdetail {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String blockMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.release.plexigo.models.CastModel> castCrew = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String censorrating = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String channelID = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contentType = null;
    private final int contentid = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contentname = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String country = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object dashURL = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String duration = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object fairplayCertificateURL = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object fairplayLicenseURL = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String genere = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object hlsURL = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String imagepath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String inr = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String isBrowserBlock = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String isDRMContent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String isFavourite = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String isFilmFestival = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String isLive = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object isLiveDRM = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String isQnAEnabled = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String isWatchLater = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String language = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.release.plexigo.models.LanguageModel> languages = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.release.plexigo.models.OTTModel> ottPlatforms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.release.plexigo.models.PaymentGateway> paymentGateway = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pollInterval = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String posterpath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ppv = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ppvTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ppvType = null;
    private final int ppvValidity = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String rating = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String releaseyear = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String rentValidity = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.release.plexigo.models.TvSeriesSeasons> seasons = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String showLikes = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String synopsis = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tacLink = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tacText = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object trailerpath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String usd = null;
    private final int userLikes = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object videopath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String watchDuration = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object wideimgepath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object widevineLicenseURL = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String thumbnailText = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String contentExpiryTime = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.release.plexigo.models.Contentdetail copy(@org.jetbrains.annotations.NotNull()
    java.lang.String blockMessage, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.CastModel> castCrew, @org.jetbrains.annotations.NotNull()
    java.lang.String censorrating, @org.jetbrains.annotations.NotNull()
    java.lang.String channelID, @org.jetbrains.annotations.NotNull()
    java.lang.String contentType, int contentid, @org.jetbrains.annotations.NotNull()
    java.lang.String contentname, @org.jetbrains.annotations.NotNull()
    java.lang.String country, @org.jetbrains.annotations.NotNull()
    java.lang.Object dashURL, @org.jetbrains.annotations.NotNull()
    java.lang.String duration, @org.jetbrains.annotations.Nullable()
    java.lang.Object fairplayCertificateURL, @org.jetbrains.annotations.Nullable()
    java.lang.Object fairplayLicenseURL, @org.jetbrains.annotations.NotNull()
    java.lang.String genere, @org.jetbrains.annotations.Nullable()
    java.lang.Object hlsURL, @org.jetbrains.annotations.NotNull()
    java.lang.String imagepath, @org.jetbrains.annotations.NotNull()
    java.lang.String inr, @org.jetbrains.annotations.NotNull()
    java.lang.String isBrowserBlock, @org.jetbrains.annotations.NotNull()
    java.lang.String isDRMContent, @org.jetbrains.annotations.NotNull()
    java.lang.String isFavourite, @org.jetbrains.annotations.NotNull()
    java.lang.String isFilmFestival, @org.jetbrains.annotations.NotNull()
    java.lang.String isLive, @org.jetbrains.annotations.Nullable()
    java.lang.Object isLiveDRM, @org.jetbrains.annotations.NotNull()
    java.lang.String isQnAEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String isWatchLater, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.LanguageModel> languages, @org.jetbrains.annotations.NotNull()
    java.util.List<com.release.plexigo.models.OTTModel> ottPlatforms, @org.jetbrains.annotations.NotNull()
    java.util.List<com.release.plexigo.models.PaymentGateway> paymentGateway, @org.jetbrains.annotations.NotNull()
    java.lang.String pollInterval, @org.jetbrains.annotations.NotNull()
    java.lang.String posterpath, @org.jetbrains.annotations.NotNull()
    java.lang.String ppv, @org.jetbrains.annotations.NotNull()
    java.lang.String ppvTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String ppvType, int ppvValidity, @org.jetbrains.annotations.NotNull()
    java.lang.String rating, @org.jetbrains.annotations.NotNull()
    java.lang.String releaseyear, @org.jetbrains.annotations.NotNull()
    java.lang.String rentValidity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.release.plexigo.models.TvSeriesSeasons> seasons, @org.jetbrains.annotations.NotNull()
    java.lang.String showLikes, @org.jetbrains.annotations.NotNull()
    java.lang.String synopsis, @org.jetbrains.annotations.NotNull()
    java.lang.String tacLink, @org.jetbrains.annotations.NotNull()
    java.lang.String tacText, @org.jetbrains.annotations.Nullable()
    java.lang.Object trailerpath, @org.jetbrains.annotations.NotNull()
    java.lang.String usd, int userLikes, @org.jetbrains.annotations.Nullable()
    java.lang.Object videopath, @org.jetbrains.annotations.NotNull()
    java.lang.String watchDuration, @org.jetbrains.annotations.Nullable()
    java.lang.Object wideimgepath, @org.jetbrains.annotations.NotNull()
    java.lang.Object widevineLicenseURL, @org.jetbrains.annotations.Nullable()
    java.lang.String thumbnailText, @org.jetbrains.annotations.Nullable()
    java.lang.String contentExpiryTime) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Contentdetail(@org.jetbrains.annotations.NotNull()
    java.lang.String blockMessage, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.CastModel> castCrew, @org.jetbrains.annotations.NotNull()
    java.lang.String censorrating, @org.jetbrains.annotations.NotNull()
    java.lang.String channelID, @org.jetbrains.annotations.NotNull()
    java.lang.String contentType, int contentid, @org.jetbrains.annotations.NotNull()
    java.lang.String contentname, @org.jetbrains.annotations.NotNull()
    java.lang.String country, @org.jetbrains.annotations.NotNull()
    java.lang.Object dashURL, @org.jetbrains.annotations.NotNull()
    java.lang.String duration, @org.jetbrains.annotations.Nullable()
    java.lang.Object fairplayCertificateURL, @org.jetbrains.annotations.Nullable()
    java.lang.Object fairplayLicenseURL, @org.jetbrains.annotations.NotNull()
    java.lang.String genere, @org.jetbrains.annotations.Nullable()
    java.lang.Object hlsURL, @org.jetbrains.annotations.NotNull()
    java.lang.String imagepath, @org.jetbrains.annotations.NotNull()
    java.lang.String inr, @org.jetbrains.annotations.NotNull()
    java.lang.String isBrowserBlock, @org.jetbrains.annotations.NotNull()
    java.lang.String isDRMContent, @org.jetbrains.annotations.NotNull()
    java.lang.String isFavourite, @org.jetbrains.annotations.NotNull()
    java.lang.String isFilmFestival, @org.jetbrains.annotations.NotNull()
    java.lang.String isLive, @org.jetbrains.annotations.Nullable()
    java.lang.Object isLiveDRM, @org.jetbrains.annotations.NotNull()
    java.lang.String isQnAEnabled, @org.jetbrains.annotations.NotNull()
    java.lang.String isWatchLater, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.release.plexigo.models.LanguageModel> languages, @org.jetbrains.annotations.NotNull()
    java.util.List<com.release.plexigo.models.OTTModel> ottPlatforms, @org.jetbrains.annotations.NotNull()
    java.util.List<com.release.plexigo.models.PaymentGateway> paymentGateway, @org.jetbrains.annotations.NotNull()
    java.lang.String pollInterval, @org.jetbrains.annotations.NotNull()
    java.lang.String posterpath, @org.jetbrains.annotations.NotNull()
    java.lang.String ppv, @org.jetbrains.annotations.NotNull()
    java.lang.String ppvTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String ppvType, int ppvValidity, @org.jetbrains.annotations.NotNull()
    java.lang.String rating, @org.jetbrains.annotations.NotNull()
    java.lang.String releaseyear, @org.jetbrains.annotations.NotNull()
    java.lang.String rentValidity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.release.plexigo.models.TvSeriesSeasons> seasons, @org.jetbrains.annotations.NotNull()
    java.lang.String showLikes, @org.jetbrains.annotations.NotNull()
    java.lang.String synopsis, @org.jetbrains.annotations.NotNull()
    java.lang.String tacLink, @org.jetbrains.annotations.NotNull()
    java.lang.String tacText, @org.jetbrains.annotations.Nullable()
    java.lang.Object trailerpath, @org.jetbrains.annotations.NotNull()
    java.lang.String usd, int userLikes, @org.jetbrains.annotations.Nullable()
    java.lang.Object videopath, @org.jetbrains.annotations.NotNull()
    java.lang.String watchDuration, @org.jetbrains.annotations.Nullable()
    java.lang.Object wideimgepath, @org.jetbrains.annotations.NotNull()
    java.lang.Object widevineLicenseURL, @org.jetbrains.annotations.Nullable()
    java.lang.String thumbnailText, @org.jetbrains.annotations.Nullable()
    java.lang.String contentExpiryTime) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBlockMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.CastModel> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.CastModel> getCastCrew() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCensorrating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChannelID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContentType() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getContentid() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContentname() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCountry() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getDashURL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFairplayCertificateURL() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFairplayLicenseURL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGenere() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHlsURL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImagepath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInr() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isBrowserBlock() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isDRMContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isFavourite() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isFilmFestival() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isLive() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isLiveDRM() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isQnAEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String isWatchLater() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.LanguageModel> component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.release.plexigo.models.LanguageModel> getLanguages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.release.plexigo.models.OTTModel> component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.release.plexigo.models.OTTModel> getOttPlatforms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.release.plexigo.models.PaymentGateway> component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.release.plexigo.models.PaymentGateway> getPaymentGateway() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPollInterval() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPosterpath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPpv() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPpvTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPpvType() {
        return null;
    }
    
    public final int component34() {
        return 0;
    }
    
    public final int getPpvValidity() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component35() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component36() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleaseyear() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component37() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRentValidity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.release.plexigo.models.TvSeriesSeasons> component38() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.release.plexigo.models.TvSeriesSeasons> getSeasons() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component39() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShowLikes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component40() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSynopsis() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component41() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTacLink() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component42() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTacText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component43() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTrailerpath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component44() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsd() {
        return null;
    }
    
    public final int component45() {
        return 0;
    }
    
    public final int getUserLikes() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component46() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getVideopath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component47() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWatchDuration() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component48() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWideimgepath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component49() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getWidevineLicenseURL() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component50() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getThumbnailText() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component51() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContentExpiryTime() {
        return null;
    }
}