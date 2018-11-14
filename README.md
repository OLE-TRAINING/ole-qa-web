# ole-qa-web
The project currently accepts two browsers, but in the future it will accept more

Follow these steps to execute the project:

1)put your browsers in that versions
Mozilla Firefox version: 63.0
https://www.mozilla.org/en-US/firefox/releases/

google chrome version: current
https://www.google.pt/intl/pt-PT/chrome/?brand=CHBD&gclid=EAIaIQobChMImKDbqP7T3gIVhQ2RCh2hMwqPEAAYASAAEgJiyfD_BwE&gclsrc=aw.ds

2) Download the files in these repository(and extract if necessary). You'll need to see jars.class on the files

3) Import a new Maven Project to Eclipse IDE

4) run FlowTestNotLogged.java(in tests) as JUnit test
   or
   run SuitFlowTests.jave(in suit) as JUnit test

*to run in another browser change in properties(main/core/Properties.java), change:
public static Browsers browser = Browsers.FIREFOX;
to
public static Browsers browser = Browsers.CHROME;
