# Dynatrace-LoadRunner-Converter

The LoadRunner Request Tagging tool inserts a short method addDynatraceHeaderTest in your globals.h or globals.js file that populates the x-dynatrace-test header.
It also parses your .c or .js files and automatically adds a call to this method before one of the key LoadRunner methods is called.
Both C and JavaScript scripting languages are supported.

java -jar Dt-LoadRunner-request-tagging.jar <mode> <path parameter> <optional parameters>

- mode parameter
	- **insert**:  Adds the Dynatrace HTTP header to the selected LoadRunner scripts.
	- **delete**: Removes all modifications made previously by the LoadRunner Request Tagging tool.
- path parameter
	- **-path <filepath>**: Use for scanning all directories and subdirectories for script files and inserting/deleting scripts into them.
	- **-body <files> -header <files>**: Use to specify if header or body files should be processed. The file separator between files is &.
- optional parameters
	- **-LSN <value>**: Sets the load script name to a value passed after -LSN. If skipped, the script name will be taken from the *.usr file
	- **-c**: Sets C as the scripting language (the default)
	- **-js**: Sets JavaScript as the scripting language
	- **-help**: Prints usage.
	