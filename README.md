<a name="project" />

# Dynatrace LoadRunner Request Tagging tool

The LoadRunner Request Tagging tool inserts a short method `addDynatraceHeaderTest` in your _globals.h_ or _globals.js_ file that populates the `x-dynatrace-test` header.
It also parses your _.c_ or _.js_ files and automatically adds a call to this method before one of the key LoadRunner methods is called.
Both C and JavaScript scripting languages are supported.

    java -jar Dt-LoadRunner-request-tagging.jar <mode> <path> <optional parameters>

- `<mode>` parameter
	- `insert`: adds the Dynatrace HTTP header to the selected LoadRunner scripts.
	- `delete`: removes all modifications made previously by the LoadRunner Request Tagging tool.
- `<path>` parameter
	- `-path <filepath>`: modifies all the C or JavaScript script files found under specified `<filepath>`.
	- `-body <files> -header <files>`: modifies only the listed body and header files. Use `&` to separate file names.
- `<optional parameters>`
	- `-LSN <value>`: sets the load script name to a specified `<value>`. If skipped, the script name will be taken from the _.usr_ file
	- `-c`: sets C as the scripting language (the default)
	- `-js`: sets JavaScript as the scripting language
	- `-help`: prints usage.

<a name="furtherreading" />

## Further readings

* <a href="http://www.dynatrace.com/support/help/integrations/test-automation-frameworks/how-do-i-integrate-dynatrace-into-loadrunner-scripts/" target="_blank">How do I integrate Dynatrace into LoadRunner scripts</a> in the Dynatrace documentation

<a name="help" />

## Help & Support

The Dynatrace LoadRunner Request Tagging Tool is an open source project, currently in beta status. The features are fully supported by Dynatrace. 

**Get Help**
* Ask a question in the <a href="https://answers.dynatrace.com/spaces/482/view.html" target="_blank">product forums</a>
* Read the <a href="https://www.dynatrace.com/support/help/integrations/test-automation-frameworks/how-do-i-integrate-dynatrace-into-loadrunner-scripts/" target="_blank">product documentation</a>

**Open a <a href="https://github.com/Dynatrace/Dynatrace-LoadRunner-Request-Tagging/issues">GitHub issue</a> to:**
* Report minor defects, minor items or typos
* Ask for improvements or changes
* Ask any questions related to the community effort

SLAs don't apply for GitHub tickets

**Customers can open a ticket on the <a href="https://support.dynatrace.com/supportportal/" target="_blank">Dynatrace support portal</a> to:**
* Get support from the Dynatrace technical support engineering team
* Manage and resolve product related technical issues

SLAs apply according to the customer's support level.

<a name="releasenotes" />

## Release notes

see also <a href="https://github.com/Dynatrace/Dynatrace-LoadRunner-Request-Tagging/releases" target="_blank">all the available releases</a>

|Version|Description                            |
|:------|:--------------------------------------|
|[1.1.0](https://github.com/Dynatrace/Dynatrace-LoadRunner-Request-Tagging/releases/tag/release)  |Covering full JavaScript support<br/>Cleaning up the source code<br/>Fixing reported issues|
|[pre release 1](https://github.com/Dynatrace/Dynatrace-LoadRunner-Request-Tagging/releases/tag/pre-release-1)|Initial release|
