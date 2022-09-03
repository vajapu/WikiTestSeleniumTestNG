# WikiTestSeleniumTestNG
Selenium test automation framework for RIL interview feedback

What's implemented from feedback ..?
* Added @CacheLookUp annotation for PageFactory Elements
 - Handled StaleElement exception using WebElement cachedElement = ((WrapsElement) <PageFactory element>).getWrappedElement();

* Refactored framework (removed extends where it didn't make sense) , separated object creation to support parallel running

* Tests run in parallel, set to 4 threads in TestNG.xml file

How to run..
make sure maven is setup
'cd' to project root directory
execute 'mvn test'
