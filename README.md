# Grammar Utilities
This project contains various utilities for converting numerical values into grammatically formatted Strings.

Also contains a utility for setting fields on any given object, even when that object does not have any public variables or setter functions.

GrammarUtil is the main class that tests the various functions.

Util is the class containing the Utility methods mentioned above.
  * setFields():  Uses java reflection to set the fields of any passed in object from a Map of String-to-Object pairs.
  * getPlace():  A grammar utility for outputting correct grammar telling which place a number represents. e.g., 1st place, 2nd place, 3rd place, 4th place, etc...
  * howLongAgo():  Given a date representing a time in the past, will output a grammatically correct String stating how long ago in the closest time unit of minutes, hours or days.

Document is a sample class used in the setFields test.

PrivacyObject is a simple class representing privacy settings.  It is contained in the Document class.

The project requires Java 8, has no external dependencies and can be executed at the command line from the base directory using maven 3: mvn exec:java

