package com.release.plexigo.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ae\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001b2\b\b\u0001\u0010\u001d\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010!\u001a\u00020\"H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J!\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010%\u001a\u00020&H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J!\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u0010*\u001a\u00020+H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J!\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\b\b\u0001\u0010/\u001a\u000200H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101J-\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u00102\u001a\u000203H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00104J!\u00105\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u00106\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107J!\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\b\b\u0001\u0010:\u001a\u00020;H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010<J!\u0010=\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u0010>\u001a\u00020?H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010@J!\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010B\u001a\u00020CH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DJ!\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u00032\b\b\u0001\u0010G\u001a\u00020HH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010IJ!\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010K\u001a\u00020LH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010MJ!\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u00032\b\b\u0001\u0010P\u001a\u00020QH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010RJ+\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u00032\b\b\u0001\u0010U\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VJ\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020X0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ!\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u00032\b\b\u0001\u0010G\u001a\u00020HH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010IJ+\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u00032\b\b\u0001\u0010^\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010_J!\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u00032\b\b\u0001\u0010b\u001a\u00020cH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010dJ!\u0010e\u001a\b\u0012\u0004\u0012\u00020f0\u00032\b\b\u0001\u00106\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ!\u0010h\u001a\b\u0012\u0004\u0012\u00020i0\u00032\b\b\u0001\u0010j\u001a\u00020kH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010lJ!\u0010m\u001a\b\u0012\u0004\u0012\u00020n0\u00032\b\b\u0001\u0010o\u001a\u00020pH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010qJ+\u0010r\u001a\b\u0012\u0004\u0012\u00020s0\u00032\b\b\u0001\u0010t\u001a\u00020\u001b2\b\b\u0001\u0010u\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VJ!\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u00032\b\b\u0001\u0010t\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ\u0017\u0010x\u001a\b\u0012\u0004\u0012\u00020y0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ+\u0010z\u001a\b\u0012\u0004\u0012\u00020{0\u00032\b\b\u0001\u0010^\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VJ!\u0010|\u001a\b\u0012\u0004\u0012\u00020}0\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ8\u0010~\u001a\b\u0012\u0004\u0012\u00020\u007f0\u00032\t\b\u0001\u0010\u0080\u0001\u001a\u00020\u001b2\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u001b2\t\b\u0001\u0010\u0082\u0001\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ%\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020n0\u00032\n\b\u0001\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0086\u0001J#\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ\u0019\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ&\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u008c\u00010\u00032\n\b\u0001\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ\u0018\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020n0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ\"\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010b\u001a\u00020cH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010dJ.\u0010\u0094\u0001\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010\u00032\t\b\u0001\u0010\u0096\u0001\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VJ-\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020w0\u00032\t\b\u0001\u0010\u0080\u0001\u001a\u00020\u001b2\b\b\u0001\u0010u\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VJB\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020n0\u00032\t\b\u0001\u0010\u0099\u0001\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001b2\b\b\u0001\u0010\u001d\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u009a\u0001J\u0019\u0010\u009b\u0001\u001a\t\u0012\u0005\u0012\u00030\u009c\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ#\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u009e\u00010\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107J#\u0010\u009f\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a0\u00010\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ\"\u0010\u00a1\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010b\u001a\u00020cH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010dJ.\u0010\u00a2\u0001\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010\u00032\t\b\u0001\u0010\u00a3\u0001\u001a\u00020\u001b2\b\b\u0001\u00106\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VJ.\u0010\u00a4\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a5\u00010\u00032\t\b\u0001\u0010\u00a3\u0001\u001a\u00020\u001b2\b\b\u0001\u00106\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010VJ\"\u0010\u00a6\u0001\u001a\b\u0012\u0004\u0012\u00020f0\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ\"\u0010\u00a7\u0001\u001a\b\u0012\u0004\u0012\u00020n0\u00032\b\b\u0001\u0010b\u001a\u00020cH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010dJ&\u0010\u00a8\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010\u00032\n\b\u0001\u0010\u00a9\u0001\u001a\u00030\u00aa\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00ab\u0001J#\u0010\u00ac\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010\u00032\b\b\u0001\u0010G\u001a\u00020HH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010IJ%\u0010\u00ae\u0001\u001a\b\u0012\u0004\u0012\u00020}0\u00032\n\b\u0001\u0010\u00af\u0001\u001a\u00030\u00b0\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00b1\u0001J%\u0010\u00b2\u0001\u001a\b\u0012\u0004\u0012\u00020n0\u00032\n\b\u0001\u0010\u00b3\u0001\u001a\u00030\u00b4\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00b5\u0001J%\u0010\u00b6\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\n\b\u0001\u0010\u00b7\u0001\u001a\u00030\u00b8\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00b9\u0001J&\u0010\u00ba\u0001\u001a\t\u0012\u0005\u0012\u00030\u00bb\u00010\u00032\n\b\u0001\u0010\u00bc\u0001\u001a\u00030\u00bd\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00be\u0001J\u0019\u0010\u00bf\u0001\u001a\t\u0012\u0005\u0012\u00030\u00c0\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ9\u0010\u00c1\u0001\u001a\b\u0012\u0004\u0012\u00020n0\u00032\t\b\u0001\u0010\u0080\u0001\u001a\u00020\u001b2\t\b\u0001\u0010\u0081\u0001\u001a\u00020\u001b2\t\b\u0001\u0010\u0082\u0001\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ$\u0010\u00c2\u0001\u001a\t\u0012\u0005\u0012\u00030\u00c3\u00010\u00032\t\b\u0001\u0010\u00c4\u0001\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107J&\u0010\u00c5\u0001\u001a\t\u0012\u0005\u0012\u00030\u00c6\u00010\u00032\n\b\u0001\u0010\u00c7\u0001\u001a\u00030\u00c8\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00c9\u0001J#\u0010\u00ca\u0001\u001a\t\u0012\u0005\u0012\u00030\u00cb\u00010\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ\u0019\u0010\u00cc\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010YJ\"\u0010\u00cd\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ#\u0010\u00ce\u0001\u001a\t\u0012\u0005\u0012\u00030\u00cf\u00010\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ#\u0010\u00d0\u0001\u001a\t\u0012\u0005\u0012\u00030\u00d1\u00010\u00032\b\b\u0001\u00106\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ\"\u0010\u00d2\u0001\u001a\b\u0012\u0004\u0012\u00020[0\u00032\b\b\u0001\u00106\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107JM\u0010\u00d3\u0001\u001a\b\u0012\u0004\u0012\u00020n0\u00032\t\b\u0001\u0010\u00d4\u0001\u001a\u00020\u001b2\t\b\u0001\u0010\u00d5\u0001\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001b2\b\b\u0001\u0010\u001d\u001a\u00020\u001b2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00d6\u0001J$\u0010\u00d7\u0001\u001a\t\u0012\u0005\u0012\u00030\u00d8\u00010\u00032\t\b\u0001\u0010\u00d9\u0001\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ%\u0010\u00da\u0001\u001a\b\u0012\u0004\u0012\u00020n0\u00032\n\b\u0001\u0010\u00db\u0001\u001a\u00030\u00dc\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00dd\u0001J%\u0010\u00de\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u00df\u0001\u001a\u00030\u00e0\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00e1\u0001J&\u0010\u00e2\u0001\u001a\t\u0012\u0005\u0012\u00030\u00e3\u00010\u00032\n\b\u0001\u0010\u00e4\u0001\u001a\u00030\u00e5\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00e6\u0001J#\u0010\u00e7\u0001\u001a\t\u0012\u0005\u0012\u00030\u00e8\u00010\u00032\b\b\u0001\u0010*\u001a\u00020+H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J&\u0010\u00e9\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ea\u00010\u00032\n\b\u0001\u0010\u00eb\u0001\u001a\u00030\u00ec\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00ed\u0001J#\u0010\u00ee\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ef\u00010\u00032\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ%\u0010\u00f0\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u00f1\u0001\u001a\u00030\u00f2\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00f3\u0001J\"\u0010\u00f4\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010K\u001a\u00020LH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010MJ\"\u0010\u00f5\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J%\u0010\u00f6\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u00f7\u0001\u001a\u00030\u00f8\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00f9\u0001J%\u0010\u00fa\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u00fb\u0001\u001a\u00030\u00fc\u0001H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00fd\u0001J%\u0010\u00fe\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u00ff\u0001\u001a\u00030\u0080\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0081\u0002J&\u0010\u0082\u0002\u001a\t\u0012\u0005\u0012\u00030\u0083\u00020\u00032\n\b\u0001\u0010\u0084\u0002\u001a\u00030\u0085\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0086\u0002J\"\u0010\u0087\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010K\u001a\u00020LH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010MJ%\u0010\u0088\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u0089\u0002\u001a\u00030\u008a\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u008b\u0002J%\u0010\u008c\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u008d\u0002\u001a\u00030\u008e\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u008f\u0002J%\u0010\u0090\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u0091\u0002\u001a\u00030\u0092\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0093\u0002J%\u0010\u0094\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u0095\u0002\u001a\u00030\u0096\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0097\u0002J%\u0010\u0098\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u0099\u0002\u001a\u00030\u009a\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u009b\u0002J%\u0010\u009c\u0002\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0001\u0010\u009d\u0002\u001a\u00030\u009e\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u009f\u0002J&\u0010\u00a0\u0002\u001a\t\u0012\u0005\u0012\u00030\u0083\u00020\u00032\n\b\u0001\u0010\u00a1\u0002\u001a\u00030\u00a2\u0002H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00a3\u0002J\"\u0010\u00a4\u0002\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010gJ#\u0010\u00a5\u0002\u001a\t\u0012\u0005\u0012\u00030\u00a6\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010g\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00a7\u0002"}, d2 = {"Lcom/release/plexigo/network/APIInterface;", "", "CheckIfUserPpvSubscribed", "Lretrofit2/Response;", "Lcom/release/plexigo/models/UserPpvSubscribeResponse;", "url", "", "checkUserIsPpvSubscribeRequest", "Lcom/release/plexigo/models/CheckUserIsPpvSubscribeRequest;", "(Ljava/lang/String;Lcom/release/plexigo/models/CheckUserIsPpvSubscribeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addContentToPlayList", "Lcom/release/plexigo/models/PlayListResponseModel;", "removePlayListContentRequest", "Lcom/release/plexigo/models/RemovePlayListContentRequest;", "(Lcom/release/plexigo/models/RemovePlayListContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addWatchHistory", "Lcom/release/plexigo/models/AddWatchHistoryResponse;", "addWatchHistoryRequest", "Lcom/release/plexigo/models/AddWatchHistoryRequest;", "(Lcom/release/plexigo/models/AddWatchHistoryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addWatchLaterApi", "watchLaterApiRequest", "Lcom/release/plexigo/models/WatchListApiRequest;", "(Lcom/release/plexigo/models/WatchListApiRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callFollowedPlaylistApi", "Lcom/release/plexigo/models/UserPlayListResponseModel;", "UserId", "", "PageCount", "Limit", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLikeDislikeActor", "Lcom/release/plexigo/models/LikeDisLikeActorResponse;", "likeDisLikeActorRequest", "Lcom/release/plexigo/models/LikeDisLikeActorRequest;", "(Lcom/release/plexigo/models/LikeDisLikeActorRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callLikeDislikeContent", "likeDislikeContentRequest", "Lcom/release/plexigo/models/LikeDislikeContentRequest;", "(Lcom/release/plexigo/models/LikeDislikeContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkGPSContentValidApi", "Lokhttp3/ResponseBody;", "gpsCoordinatesRequest", "Lcom/release/plexigo/models/GpsCoordinatesRequest;", "(Lcom/release/plexigo/models/GpsCoordinatesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkGeoAuthorizedContent", "Lcom/release/plexigo/models/ContentGeoAuthorizedResponse;", "geoAuthorizesRequest", "Lcom/release/plexigo/models/ContentGeoAuthorizesRequest;", "(Lcom/release/plexigo/models/ContentGeoAuthorizesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIfOfferSubscribed", "Lcom/release/plexigo/models/CheckIfOfferSubscribed;", "(Ljava/lang/String;Lcom/release/plexigo/models/CheckIfOfferSubscribed;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkUserExist", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPaypalPaymentOrder", "Lcom/release/plexigo/models/PaypalPaymentResponse;", "paypalOrderRequest", "Lcom/release/plexigo/models/PaypalOrderRequest;", "(Lcom/release/plexigo/models/PaypalOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSendbirdUser", "createSendBirdUserrequest", "Lcom/release/plexigo/models/CreateSendBirdUserrequest;", "(Lcom/release/plexigo/models/CreateSendBirdUserrequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUserPlayList", "createPlayListRequest", "Lcom/release/plexigo/models/CreatePlayListRequest;", "(Lcom/release/plexigo/models/CreatePlayListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAccount", "Lcom/release/plexigo/models/DeleteAccountResponse;", "quickPickDataRequest", "Lcom/release/plexigo/models/QuickPickDataRequest;", "(Lcom/release/plexigo/models/QuickPickDataRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "followUserPlayLists", "playListRequest", "Lcom/release/plexigo/models/PlayListRequest;", "(Lcom/release/plexigo/models/PlayListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "forgotPasswordApi", "Lcom/release/plexigo/models/ForgotPasswordResponse;", "forgotPasswordRequest", "Lcom/release/plexigo/models/ForgotPasswordRequest;", "(Lcom/release/plexigo/models/ForgotPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActorDetail", "Lcom/release/plexigo/models/ActorDetailResponseModel;", "actorId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAppVersion", "Lcom/release/plexigo/models/AppVersionResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBannerApi", "Lcom/release/plexigo/models/BannerResponseModel;", "getBundleDetail", "Lcom/release/plexigo/models/OfferDescriptionModel;", "bundleId", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBundleListing", "Lcom/release/plexigo/models/OffersResponseModel;", "popularInAreaListRequest", "Lcom/release/plexigo/models/PopularInAreaListRequest;", "(Lcom/release/plexigo/models/PopularInAreaListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChannelApi", "Lcom/release/plexigo/models/ChannelFestivalResponseModel;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChannelCategories", "Lcom/release/plexigo/models/ChannelApiResponseModel;", "channelCategoriesRequest", "Lcom/release/plexigo/models/ChannelCategoriesRequest;", "(Lcom/release/plexigo/models/ChannelCategoriesRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContentByActor", "Lcom/release/plexigo/models/MovieListingResponse;", "searchMoviesByActorRequest", "Lcom/release/plexigo/models/SearchMoviesByActorRequest;", "(Lcom/release/plexigo/models/SearchMoviesByActorRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContentToken", "Lcom/release/plexigo/models/ContentTokenResponse;", "contentId", "userid", "getContentVideoLink", "Lcom/release/plexigo/models/MovieDetailResponse;", "getCountries", "Lcom/release/plexigo/models/CountryResponseModel;", "getCouponCode", "Lcom/release/plexigo/models/CouponCodesResponseModel;", "getFavouritePeople", "Lcom/release/plexigo/models/ActorListingResponseModel;", "getFeaturedInPlaylists", "Lcom/release/plexigo/models/UserPlayListResponse;", "movieId", "pageNo", "limit", "getFilteredContent", "filteredContentRequest", "Lcom/release/plexigo/models/FilteredContentRequest;", "(Lcom/release/plexigo/models/FilteredContentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFollowedUserList", "Lcom/release/plexigo/models/TopUserListResponseModel;", "getGenre", "Lcom/release/plexigo/models/HomeGenreResponseModel;", "getHomePageListing", "Lcom/release/plexigo/models/HomeApiResponseModel;", "homePageListingRequest", "Lcom/release/plexigo/models/HomePageListingRequest;", "(Lcom/release/plexigo/models/HomePageListingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLanguages", "Lcom/release/plexigo/models/HomeLanguagesResponseModel;", "getLibraryApi", "getListForEveryMood", "getMoodPlaylistContentInterface", "Lcom/release/plexigo/models/PlayListContentResponseModel;", "moodPlaylistId", "getMovieDetailApi", "getMovieListing", "CategoryId", "(IIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOTTPlatforms", "Lcom/release/plexigo/models/OTTResponseModel;", "getOnBoardingData", "Lcom/release/plexigo/models/OnBoardingResponseModel;", "getOnBoardingPollComplete", "Lcom/release/plexigo/models/OnBoardingCompleteResponse;", "getPlayList", "getPlayListContent", "playListId", "getPlayListDetail", "Lcom/release/plexigo/models/PlayListDetailResponse;", "getPopularChannels", "getPopularInYourArea", "getPopularUsers", "popularUsersRequest", "Lcom/release/plexigo/models/PopularUsersRequestModel;", "(Lcom/release/plexigo/models/PopularUsersRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuickPickData", "Lcom/release/plexigo/models/QuickPickDataResponse;", "getSearchActors", "searchActorsRequest", "Lcom/release/plexigo/models/SearchActorsRequestModel;", "(Lcom/release/plexigo/models/SearchActorsRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchMovies", "searchMoviesRequest", "Lcom/release/plexigo/models/SearchMoviesRequestModel;", "(Lcom/release/plexigo/models/SearchMoviesRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchPlayList", "searchPlaylistsRequest", "Lcom/release/plexigo/models/SearchPlaylistsRequestModel;", "(Lcom/release/plexigo/models/SearchPlaylistsRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchPlaylistUsers", "Lcom/release/plexigo/models/PlaylistUserResponseModel;", "searchPlaylistUsersRequest", "Lcom/release/plexigo/models/SearchPlaylistUsersRequestModel;", "(Lcom/release/plexigo/models/SearchPlaylistUsersRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSignUpTermsAndCondition", "Lcom/release/plexigo/models/OnOtpValidationResponse;", "getSimilarMovieListing", "getStates", "Lcom/release/plexigo/models/StateResponseModel;", "country", "getSuggestiveSearch", "Lcom/release/plexigo/models/SearchSuggestionResponseModel;", "searchSuggestionsRequest", "Lcom/release/plexigo/models/SearchSuggestionsRequestModel;", "(Lcom/release/plexigo/models/SearchSuggestionsRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopGenre", "Lcom/release/plexigo/models/TopGenreResponseModel;", "getTopUserList", "getUserPlayList", "getUserProfile", "Lcom/release/plexigo/models/UserProfileDetailResponseModel;", "getWatchHistory", "Lcom/release/plexigo/models/WatchHistoryResponseModel;", "getWhatsNewMovies", "getcontentByChannelOTT", "channelId", "channelCategoryId", "(IIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getfestivalDetails", "Lcom/release/plexigo/models/FestivalResponseModel;", "festivalId", "getrecentSearch", "recentSearchResultsRequest", "Lcom/release/plexigo/models/RecentSearchResultsRequestModel;", "(Lcom/release/plexigo/models/RecentSearchResultsRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "linkAuthCodeUser", "linkAuthCodeUserRequest", "Lcom/release/plexigo/models/LinkAuthCodeUserRequest;", "(Lcom/release/plexigo/models/LinkAuthCodeUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginApi", "Lcom/release/plexigo/models/LoginApiResponse;", "loginApiRequest", "Lcom/release/plexigo/models/LoginApiRequest;", "(Lcom/release/plexigo/models/LoginApiRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postGpsCoordinates", "Lcom/release/plexigo/models/GpsCoordinatesResponse;", "registrationApi", "Lcom/release/plexigo/models/RegistrationResponse;", "registrationRequest", "Lcom/release/plexigo/models/RegistrationRequest;", "(Lcom/release/plexigo/models/RegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeContentUserPlayList", "Lcom/release/plexigo/models/RemoveContentUserPlayListResponse;", "removeFromFavouritesList", "removeFromFavouriteListRequest", "Lcom/release/plexigo/models/RemoveFromFavouriteListRequest;", "(Lcom/release/plexigo/models/RemoveFromFavouriteListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removePlayList", "removeWatchLaterApi", "renamePlayList", "renamePlayListRequest", "Lcom/release/plexigo/models/RenamePlayListRequest;", "(Lcom/release/plexigo/models/RenamePlayListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "resetPasswordRequest", "Lcom/release/plexigo/models/ResetPasswordRequest;", "(Lcom/release/plexigo/models/ResetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOnBoardingData", "saveOnBoardingRequest", "Lcom/release/plexigo/models/SaveOnBoardingRequest;", "(Lcom/release/plexigo/models/SaveOnBoardingRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendVerificationCode", "Lcom/release/plexigo/models/VerifyOtpResponse;", "sendVerificationCodeRequest", "Lcom/release/plexigo/models/SendVerificationCodeRequest;", "(Lcom/release/plexigo/models/SendVerificationCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unFollowUserPlayList", "updateFolloState", "updateFollowStateRequest", "Lcom/release/plexigo/models/UpdateFollowStateRequest;", "(Lcom/release/plexigo/models/UpdateFollowStateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlayListType", "updatePlayListTypeRequest", "Lcom/release/plexigo/models/UpdatePlayListTypeRequest;", "(Lcom/release/plexigo/models/UpdatePlayListTypeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "updateProfileApiRequest", "Lcom/release/plexigo/models/UpdateProfileApiRequest;", "(Lcom/release/plexigo/models/UpdateProfileApiRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updaterequestApprovedStatus", "updateRequestApprovedAPiRequest", "Lcom/release/plexigo/models/UpdateRequestApprovedAPiRequest;", "(Lcom/release/plexigo/models/UpdateRequestApprovedAPiRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFcmToken", "fcmTokenRequest", "Lcom/release/plexigo/models/FcmTokenRequest;", "(Lcom/release/plexigo/models/FcmTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadProfilePicture", "file", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyOtp", "verifyOtpRequest", "Lcom/release/plexigo/models/VerifyOtpRequest;", "(Lcom/release/plexigo/models/VerifyOtpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "viewUserPlayList", "viewUserPlayListDetail", "Lcom/release/plexigo/models/ViewUserPlaylistDetailResponseModel;", "app_debug"})
public abstract interface APIInterface {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getAppVersion")
    public abstract java.lang.Object getAppVersion(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.AppVersionResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/getOnboardingpollcomplete/{UserId}")
    public abstract java.lang.Object getOnBoardingPollComplete(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.OnBoardingCompleteResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/signinotp")
    public abstract java.lang.Object loginApi(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.LoginApiRequest loginApiRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.LoginApiResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/signuptc")
    public abstract java.lang.Object getSignUpTermsAndCondition(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.OnOtpValidationResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/verifyotp")
    public abstract java.lang.Object verifyOtp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.VerifyOtpRequest verifyOtpRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.VerifyOtpResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/signup")
    public abstract java.lang.Object registrationApi(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.RegistrationRequest registrationRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.RegistrationResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/forgetpassword")
    public abstract java.lang.Object forgotPasswordApi(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.ForgotPasswordRequest forgotPasswordRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ForgotPasswordResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/QuickPick")
    public abstract java.lang.Object getQuickPickData(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.QuickPickDataRequest quickPickDataRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.QuickPickDataResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/ContentLike")
    public abstract java.lang.Object callLikeDislikeContent(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.LikeDislikeContentRequest likeDislikeContentRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.LikeDisLikeActorResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getmoviedetail/{movieId}/{userid}")
    public abstract java.lang.Object getMovieDetailApi(@retrofit2.http.Path(value = "movieId")
    int movieId, @retrofit2.http.Path(value = "userid")
    int userid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieDetailResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "movie/iscontentlock")
    public abstract java.lang.Object checkGeoAuthorizedContent(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.ContentGeoAuthorizesRequest geoAuthorizesRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ContentGeoAuthorizedResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST()
    public abstract java.lang.Object CheckIfUserPpvSubscribed(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Url()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.CheckUserIsPpvSubscribeRequest checkUserIsPpvSubscribeRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPpvSubscribeResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST()
    public abstract java.lang.Object checkIfOfferSubscribed(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Url()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.CheckIfOfferSubscribed checkIfOfferSubscribed, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPpvSubscribeResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/UserWatchHistory")
    public abstract java.lang.Object addWatchHistory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.AddWatchHistoryRequest addWatchHistoryRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.AddWatchHistoryResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getContentToken/{contentId}/{userid}")
    public abstract java.lang.Object getContentToken(@retrofit2.http.Path(value = "contentId")
    int contentId, @retrofit2.http.Path(value = "userid")
    int userid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ContentTokenResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getSimilarContent/{movieId}/{pageNo}/{limit}")
    public abstract java.lang.Object getSimilarMovieListing(@retrofit2.http.Path(value = "movieId")
    int movieId, @retrofit2.http.Path(value = "pageNo")
    int pageNo, @retrofit2.http.Path(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/FeaturePlaylist/{movieId}/{pageNo}/{limit}")
    public abstract java.lang.Object getFeaturedInPlaylists(@retrofit2.http.Path(value = "movieId")
    int movieId, @retrofit2.http.Path(value = "pageNo")
    int pageNo, @retrofit2.http.Path(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPlayListResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/ActorLikeDislike")
    public abstract java.lang.Object callLikeDislikeActor(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.LikeDisLikeActorRequest likeDisLikeActorRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.LikeDisLikeActorResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/getContentByActor")
    public abstract java.lang.Object getContentByActor(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.SearchMoviesByActorRequest searchMoviesByActorRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/getActorDetail/{actorId}/{UserId}")
    public abstract java.lang.Object getActorDetail(@retrofit2.http.Path(value = "actorId")
    int actorId, @retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ActorDetailResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetPlaylistContent/{playListId}/{userId}")
    public abstract java.lang.Object getPlayListContent(@retrofit2.http.Path(value = "playListId")
    int playListId, @retrofit2.http.Path(value = "userId")
    int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListContentResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetPlaylistDetails/{playListId}/{userId}")
    public abstract java.lang.Object getPlayListDetail(@retrofit2.http.Path(value = "playListId")
    int playListId, @retrofit2.http.Path(value = "userId")
    int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListDetailResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/RemoveContentUserPlaylist")
    public abstract java.lang.Object removeContentUserPlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.RemovePlayListContentRequest removePlayListContentRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.RemoveContentUserPlayListResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/FollowUserPlaylists")
    public abstract java.lang.Object followUserPlayLists(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PlayListRequest playListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/UnFollowUserPlaylists")
    public abstract java.lang.Object unFollowUserPlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PlayListRequest playListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/Renameplaylist")
    public abstract java.lang.Object renamePlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.RenamePlayListRequest renamePlayListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/Removeplaylist")
    public abstract java.lang.Object removePlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PlayListRequest playListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/Updateplaylisttype")
    public abstract java.lang.Object updatePlayListType(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.UpdatePlayListTypeRequest updatePlayListTypeRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getOnboardingdata/{UserId}")
    public abstract java.lang.Object getOnBoardingData(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "UserId")
    java.lang.String UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.OnBoardingResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/getUserFCMToken")
    public abstract java.lang.Object uploadFcmToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.FcmTokenRequest fcmTokenRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/GetBanner")
    public abstract java.lang.Object getBannerApi(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.QuickPickDataRequest quickPickDataRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.BannerResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getmoviebycategory/7/1/10/{userId}")
    public abstract java.lang.Object getWhatsNewMovies(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "userId")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.BannerResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/homepagelist")
    public abstract java.lang.Object getHomePageListing(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.HomePageListingRequest homePageListingRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.HomeApiResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetTopUserlist/1/5")
    public abstract java.lang.Object getTopUserList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.TopUserListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/GetPopularInyourarea")
    public abstract java.lang.Object getPopularInYourArea(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PopularInAreaListRequest popularInAreaListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/Listofeverymood")
    public abstract java.lang.Object getListForEveryMood(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PopularInAreaListRequest popularInAreaListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/Getchannel/{userId}")
    public abstract java.lang.Object getChannelApi(@retrofit2.http.Path(value = "userId")
    int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ChannelFestivalResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getlanguages")
    public abstract java.lang.Object getLanguages(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.HomeLanguagesResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getgenre")
    public abstract java.lang.Object getGenre(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.HomeGenreResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getOTTPlatforms")
    public abstract java.lang.Object getOTTPlatforms(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.OTTResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getwatchlater")
    public abstract java.lang.Object getLibraryApi(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/GetWatchHistory/{userId}")
    public abstract java.lang.Object getWatchHistory(@retrofit2.http.Path(value = "userId")
    int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.WatchHistoryResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getmoviebycategory/{CategoryId}/{PageCount}/{Limit}/{UserId}")
    public abstract java.lang.Object getMovieListing(@retrofit2.http.Path(value = "CategoryId")
    int CategoryId, @retrofit2.http.Path(value = "PageCount")
    int PageCount, @retrofit2.http.Path(value = "Limit")
    int Limit, @retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getContentbyChannelCategory/{channelId}/{channelCategoryId}/{PageCount}/{Limit}/{userId}")
    public abstract java.lang.Object getcontentByChannelOTT(@retrofit2.http.Path(value = "channelId")
    int channelId, @retrofit2.http.Path(value = "channelCategoryId")
    int channelCategoryId, @retrofit2.http.Path(value = "PageCount")
    int PageCount, @retrofit2.http.Path(value = "Limit")
    int Limit, @retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/getContentFilterbyGenreLanguage")
    public abstract java.lang.Object getFilteredContent(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.FilteredContentRequest filteredContentRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetUserPlaylists/{UserId}")
    public abstract java.lang.Object getUserPlayList(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPlayListResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/CreateUserPlaylist")
    public abstract java.lang.Object createUserPlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.CreatePlayListRequest createPlayListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/AddContentinUserPlaylist")
    public abstract java.lang.Object addContentToPlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.RemovePlayListContentRequest removePlayListContentRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/addwatchlater")
    public abstract java.lang.Object addWatchLaterApi(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.WatchListApiRequest watchLaterApiRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/removewatchlater")
    public abstract java.lang.Object removeWatchLaterApi(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.WatchListApiRequest watchLaterApiRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/ChannelContentListing")
    public abstract java.lang.Object getChannelCategories(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.ChannelCategoriesRequest channelCategoriesRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ChannelApiResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "movie/UserGPSCoordinates")
    public abstract java.lang.Object postGpsCoordinates(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.GpsCoordinatesRequest gpsCoordinatesRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.GpsCoordinatesResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/Getchannel/{UserId}")
    public abstract java.lang.Object getPopularChannels(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ChannelFestivalResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetFollowUserPlaylist/{UserId}/{PageCount}/{Limit}")
    public abstract java.lang.Object callFollowedPlaylistApi(@retrofit2.http.Path(value = "UserId")
    int UserId, @retrofit2.http.Path(value = "PageCount")
    int PageCount, @retrofit2.http.Path(value = "Limit")
    int Limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/GetPlaylists")
    public abstract java.lang.Object getPlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PopularInAreaListRequest popularInAreaListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getFilmFestivalDetails/")
    public abstract java.lang.Object getfestivalDetails(@retrofit2.http.Path(value = "festivalId")
    int festivalId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.FestivalResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/Search")
    public abstract java.lang.Object getSearchMovies(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.SearchMoviesRequestModel searchMoviesRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/SearchUserPlaylists")
    public abstract java.lang.Object getSearchPlayList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.SearchPlaylistsRequestModel searchPlaylistsRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/SearchActor")
    public abstract java.lang.Object getSearchActors(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.SearchActorsRequestModel searchActorsRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ActorListingResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/SearchPlaylistUser")
    public abstract java.lang.Object getSearchPlaylistUsers(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.SearchPlaylistUsersRequestModel searchPlaylistUsersRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlaylistUserResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/ViewUserPlaylist/{UserId}")
    public abstract java.lang.Object viewUserPlayList(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserPlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/ViewUserPlaylistDetails/{UserId}")
    public abstract java.lang.Object viewUserPlayListDetail(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ViewUserPlaylistDetailResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetUserFollowing/{UserId}/1/10")
    public abstract java.lang.Object getFollowedUserList(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.TopUserListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/UserFollower")
    public abstract java.lang.Object updateFolloState(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.UpdateFollowStateRequest updateFollowStateRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetUserProfile/{UserId}")
    public abstract java.lang.Object getUserProfile(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.UserProfileDetailResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "Content/BundleListing/")
    public abstract java.lang.Object getBundleListing(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PopularInAreaListRequest popularInAreaListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.OffersResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetTopGenre/{UserId}")
    public abstract java.lang.Object getTopGenre(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.TopGenreResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetFavouritePeople/{UserId}/1/10")
    public abstract java.lang.Object getFavouritePeople(@retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.ActorListingResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/DeleteFavouritPeople")
    public abstract java.lang.Object removeFromFavouritesList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.RemoveFromFavouriteListRequest removeFromFavouriteListRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/getCouponCode/{bundleId}/{UserId}")
    public abstract java.lang.Object getCouponCode(@retrofit2.http.Path(value = "bundleId")
    int bundleId, @retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.CouponCodesResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/UserDelete")
    public abstract java.lang.Object deleteAccount(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.QuickPickDataRequest quickPickDataRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.DeleteAccountResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetCountry")
    public abstract java.lang.Object getCountries(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.CountryResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetState/{country}")
    public abstract java.lang.Object getStates(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "country")
    java.lang.String country, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.StateResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/UserUpdateProfile")
    public abstract java.lang.Object updateUserProfile(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.UpdateProfileApiRequest updateProfileApiRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/UploadProfilePicture")
    public abstract java.lang.Object uploadProfilePicture(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    okhttp3.RequestBody file, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/LinkAuthCodeUser")
    public abstract java.lang.Object linkAuthCodeUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.LinkAuthCodeUserRequest linkAuthCodeUserRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/SuggestiveSearch")
    public abstract java.lang.Object getSuggestiveSearch(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.SearchSuggestionsRequestModel searchSuggestionsRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.SearchSuggestionResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "content/RecentSearch")
    public abstract java.lang.Object getrecentSearch(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.RecentSearchResultsRequestModel recentSearchResultsRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieListingResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/GetPopularUser")
    public abstract java.lang.Object getPopularUsers(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PopularUsersRequestModel popularUsersRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.TopUserListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "user/GetListofeverymoodContent/{moodPlaylistId}/{UserId}")
    public abstract java.lang.Object getMoodPlaylistContentInterface(@retrofit2.http.Path(value = "moodPlaylistId")
    int moodPlaylistId, @retrofit2.http.Path(value = "UserId")
    int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListContentResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "movie/UpdateRequestApprovalStatus")
    public abstract java.lang.Object updaterequestApprovedStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.UpdateRequestApprovedAPiRequest updateRequestApprovedAPiRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/SaveUserOnbroadingData")
    public abstract java.lang.Object saveOnBoardingData(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.SaveOnBoardingRequest saveOnBoardingRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "paypal/CreatePayPalOrder")
    public abstract java.lang.Object createPaypalPaymentOrder(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.PaypalOrderRequest paypalOrderRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PaypalPaymentResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/resetpassword")
    public abstract java.lang.Object resetPassword(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.ResetPasswordRequest resetPasswordRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.PlayListResponseModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/verifycode")
    public abstract java.lang.Object sendVerificationCode(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.SendVerificationCodeRequest sendVerificationCodeRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.VerifyOtpResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/GetContentVideoLink/{contentId}")
    public abstract java.lang.Object getContentVideoLink(@retrofit2.http.Path(value = "contentId")
    int contentId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.MovieDetailResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "https://api-4356dbe1-58e9-4ff0-9035-ac7e47bf7a68.sendbird.com/v3/users/{userId}")
    public abstract java.lang.Object checkUserExist(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "userId")
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "https://api-4356dbe1-58e9-4ff0-9035-ac7e47bf7a68.sendbird.com/v3/users")
    public abstract java.lang.Object createSendbirdUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.CreateSendBirdUserrequest createSendBirdUserrequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "movie/CheckGPSContentValid")
    public abstract java.lang.Object checkGPSContentValidApi(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.release.plexigo.models.GpsCoordinatesRequest gpsCoordinatesRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "content/GetBundleDetail/{bundleId}/{UserId}")
    public abstract java.lang.Object getBundleDetail(@retrofit2.http.Path(value = "bundleId")
    int bundleId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "UserId")
    java.lang.String UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.release.plexigo.models.OfferDescriptionModel>> continuation);
}