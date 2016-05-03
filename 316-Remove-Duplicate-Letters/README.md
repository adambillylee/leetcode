* count the number of chars in to map
* use stack to keep track of result
* use a set to dedup from stack
* if new char is dup, skip, but reduce count in map
* pop all chars from stack greater than incoming char if possible (count of head > 1)
* after clean up the stack, add incoming char into stack and set
* last, pop everything from stack and build string in reverse order