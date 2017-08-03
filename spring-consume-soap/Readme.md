#### Spring soap consuming sample

The soap service is one from a SmsGateWay in Bangladesh - [Onno Rokom Sms](https://www.onnorokomsms.com/)

When you consume a soap service, the idea is following:
* Put the wsdl in pom (direct link) or copy the wsdl file in the resource
  * In case of direct link (full pom is available in source code):
    ```
    <configuration>
        <schemaLanguage>WSDL</schemaLanguage>
        <generatePackage>com.impostercorp.soap.wsdl</generatePackage>
        <schemas>
            <schema>
                <url>http://api.onnorokomsms.com/sendsms.asmx?WSDL</url>
            </schema>
        </schemas>
    </configuration>
    ```
  * In case of wsdl in local resource
    ```
    <configuration>
            <schemaLanguage>WSDL</schemaLanguage>
            <generatePackage>com.impostercorp.soap.wsdl</generatePackage>
            <schemaDirectory>${project.basedir}/src/main/resources/wsdl</schemaDirectory>
            <schemaIncludes>
                <include>*.wsdl</include>
            </schemaIncludes>
        </configuration>
        ```
  * run `mvn clean compile` or `mvn clean install` to generate the stub

  * after that the generated objects can be used to call soap service using `WebServiceTemplate`.


