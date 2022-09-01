# Reproducer for IncompatibleClassChangeError

## Prerequisites
* Maven
* GRAALVM CE 22.3 dev build

## Steps

  ```bash
  ./run.sh /your/graal/build
  ```

### Actual

```
[...]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.933 s
[INFO] Finished at: 2022-09-01T14:58:14+02:00
[INFO] ------------------------------------------------------------------------
Hello from Kotlin!
20
Hello from Java!
========================================================================================================================
GraalVM Native Image: Generating 'kr' (executable)...
========================================================================================================================
[1/7] Initializing...                                                                                    (3.9s @ 0.19GB)
 Version info: 'GraalVM 22.3.3-dev Java 17 Mandrel Distribution'
 Java version info: '17.0.4.1-internal+0-adhoc.sgehwolf.jdk17u'
 C compiler: gcc (redhat, x86_64, 12.2.1)
 Garbage collector: Serial GC
[2/7] Performing analysis...  []                                                                         (2.5s @ 0.37GB)
   1,180 (60.67%) of  1,945 classes reachable
     896 (37.21%) of  2,408 fields reachable
   3,661 (53.18%) of  6,884 methods reachable
      19 classes,     0 fields, and     0 methods registered for reflection

Fatal error: com.oracle.graal.pointsto.util.AnalysisError$ParsingError: Error encountered while parsing hello.TestKt.getHelloStringFromJava() 
Parsing context:
   at hello.TestKt.getHelloStringFromJava(Test.kt:20)
   at hello.JavaHello.main(JavaHello.java:12)
   at com.oracle.svm.core.JavaMainWrapper.runCore0(JavaMainWrapper.java:170)
   at com.oracle.svm.core.JavaMainWrapper.runCore(JavaMainWrapper.java:130)

	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.AnalysisError.parsingError(AnalysisError.java:153)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.createFlowsGraph(MethodTypeFlow.java:104)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.ensureFlowsGraphCreated(MethodTypeFlow.java:83)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.getOrCreateMethodFlowsGraph(MethodTypeFlow.java:65)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.typestate.DefaultStaticInvokeTypeFlow.update(DefaultStaticInvokeTypeFlow.java:64)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.PointsToAnalysis$1.run(PointsToAnalysis.java:488)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.CompletionExecutor.executeCommand(CompletionExecutor.java:193)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.CompletionExecutor.lambda$executeService$0(CompletionExecutor.java:177)
	at java.base/java.util.concurrent.ForkJoinTask$RunnableExecuteAction.exec(ForkJoinTask.java:1395)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165)
Caused by: org.graalvm.compiler.java.BytecodeParser$BytecodeParserError: com.oracle.graal.pointsto.constraints.UnsupportedFeatureException: Discovered a type for which getDeclaringClass0 cannot be called: hello.Test$special$$inlined$vetoable$1. This error is reported at image build time because class hello.Test$special$$inlined$vetoable$1 is registered for linking at image build time by command line
	at parsing hello.Test.<init>(Test.kt:27)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.throwParserError(BytecodeParser.java:2518)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.throwParserError(SharedGraphBuilderPhase.java:110)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.iterateBytecodesForBlock(BytecodeParser.java:3379)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.handleBytecodeBlock(BytecodeParser.java:3331)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.processBlock(BytecodeParser.java:3176)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.build(BytecodeParser.java:1138)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.buildRootMethod(BytecodeParser.java:1030)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.GraphBuilderPhase$Instance.run(GraphBuilderPhase.java:97)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase.run(SharedGraphBuilderPhase.java:84)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.run(Phase.java:49)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.BasePhase.apply(BasePhase.java:446)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.apply(Phase.java:42)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.apply(Phase.java:38)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.AnalysisParsedGraph.parseBytecode(AnalysisParsedGraph.java:135)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisMethod.ensureGraphParsed(AnalysisMethod.java:685)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysisGraphDecoder.lookupEncodedGraph(InlineBeforeAnalysis.java:180)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.doInline(PEGraphDecoder.java:1162)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.tryInline(PEGraphDecoder.java:1145)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.trySimplifyInvoke(PEGraphDecoder.java:1003)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.handleInvoke(PEGraphDecoder.java:957)
	at jdk.internal.vm.compiler/org.graalvm.compiler.nodes.GraphDecoder.processNextNode(GraphDecoder.java:817)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysisGraphDecoder.processNextNode(InlineBeforeAnalysis.java:240)
	at jdk.internal.vm.compiler/org.graalvm.compiler.nodes.GraphDecoder.decode(GraphDecoder.java:548)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.decode(PEGraphDecoder.java:833)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysis.decodeGraph(InlineBeforeAnalysis.java:98)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.parse(MethodTypeFlowBuilder.java:176)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.apply(MethodTypeFlowBuilder.java:343)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.createFlowsGraph(MethodTypeFlow.java:93)
	... 12 more
Caused by: com.oracle.graal.pointsto.constraints.UnsupportedFeatureException: Discovered a type for which getDeclaringClass0 cannot be called: hello.Test$special$$inlined$vetoable$1. This error is reported at image build time because class hello.Test$special$$inlined$vetoable$1 is registered for linking at image build time by command line
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.SVMHost.handleLinkageError(SVMHost.java:424)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.SVMHost.getDeclaringClass(SVMHost.java:410)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.SVMHost.createHub(SVMHost.java:398)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.SVMHost.registerType(SVMHost.java:244)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisUniverse.createType(AnalysisUniverse.java:303)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisUniverse.lookupAllowUnresolved(AnalysisUniverse.java:213)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.infrastructure.WrappedConstantPool.lookupType(WrappedConstantPool.java:255)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.lookupType(BytecodeParser.java:4178)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.genNewInstance(BytecodeParser.java:4464)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.processBytecode(BytecodeParser.java:5246)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.iterateBytecodesForBlock(BytecodeParser.java:3371)
	... 37 more
Caused by: java.lang.IncompatibleClassChangeError: hello.Test and hello.Test$special$$inlined$vetoable$1 disagree on InnerClasses attribute
	at java.base/java.lang.Class.getDeclaringClass0(Native Method)
	at java.base/jdk.internal.reflect.GeneratedMethodAccessor9.invoke(Unknown Source)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.SVMHost.getDeclaringClass(SVMHost.java:407)
	... 46 more
------------------------------------------------------------------------------------------------------------------------
                        0.2s (3.2% of total time) in 10 GCs | Peak RSS: 0.67GB | CPU load: 5.54
========================================================================================================================
Failed generating 'kr' after 6.6s.
Error: Image build request failed with exit status 1
```
