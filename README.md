AutoResizingListView
====================

A `ListView` that can be placed in a `ScrollView` and "just work". It's height is set based on the number of items it contains, and it can be used with all the usual `ListView` accessories such as `ListAdapter`.

`AutoResizingListView` was conceived from [this StackOverflow thread](http://stackoverflow.com/questions/3495890/how-can-i-put-a-listview-into-a-scrollview-without-it-collapsing) and is generally considered a *bad idea* for performance reasons. However, it's probably OK for small lists.
