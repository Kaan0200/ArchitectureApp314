# ArchitectureApp314
A repository for Computer Architecture final project of EECS314 at Case Western.  Members of the repo are Kaan, Elizabeth, Zach, and Ryan.  

The project is an android application that features a processor dictionary and a search function that allows the user to look up processors based on numerous parameters.  It will also feature a glossary for terms related to processors.

## File/Class Description
- Dummy
  - GlossaryContent 
This contains the lists of GlossaryItems and the interal class that describes a glossary entry.  This is where the definitions of the glossary exist.
  - ProcessorDictionary 
This contains the list of processors and the internal class that will be displayed.  This is where each processor will be entried into the database.  But none will be added to the lists in here yet.
- DatabaseHelper 
This is the class that will be used to interact with the database, normally it would be used for updating, changing, and deleting, but since the database is set and the user of the app doesn't get to change it it won't be used much.  It was created in following with a tutorial about databases in android apps.
- GlossaryDefinitionDetailActivity
This class is the activity that will show when you select a value on the glossary, it will display the details of the object through this activity.
- GlossaryDefinitionDetailFragment
- GlossaryDefinitionListActivity
This class is the activity that actually houses the overall list of Glossary Definitions, the fragments are collected on here and the tostrings of the objects are displayed here.  This is where the list of objects is sent to, and where the fragments are generated from.
- GlossaryDefinitionListFragments
This is the single list entry on the list activity, each glossary entry gets a fragment and they are collected on the list activity to be selected here.
- MainActivity
This is the front page of the application, it contains 3 buttons that will lead to the only pages that the user can navigate to.  This serves as the home for the application as well.
- ProcessorDefinitionDetailActivity
This is the page that displays all the details of the activity that has been selected to view at a more detailed level.
- ProcessorDefinitionDetailFragment
- ProcessorDefinitionListActivity
This is the list of the activity titles that can be selected, here is where the query will be returned and the objects that it returned will be able to be selected from.
- ProcessorDefinitionListFragment
This is the selectable item on the list activity, it displays the title of the processor and can be selected to look at the details of the processors.
- ProcessorSearchActivity
This is the seach page that will contain several change-able items so that you can create a filter to grab the associated processors from.

## Tasks to complete still ##
- Complete search page
- Complete styling of Glossary / Processor Dictionary
- Add more glossary Entries
- Add more processor entries
- create query functionality and display the returned

