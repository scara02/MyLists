# MyLists

# MyArrayList 
Methods: 

void increaseSize(); - doubles the capacity of list

void add(E element); - adds element to the end of the list

void add(E element, int index); - adds element at the specified index and shiftes subsequent elements to the right by one position

E get(int index); - returns element at the specified index

boolean remove(E element); - finds index of first occurence of the element from the list and deletes it by using E remove(int index) method

E remove(int index); - deletes element at the specified index by shifting all subsequent elements to the left by one position

int size(); - returns the size of list

boolean contains(Object o); - checks if list contains specified element, if yes returns true and vice versa

void clear(); - deletes all elements from the list

int indexOf(Object o); - finds index of first occurence of the specified element and returns index, if not found returns -1

int lastIndexOf(Object o); -finds index of last occurence of the specified element and returns index, if not found returns -1


# MyLinkedList
Methods: 

void add(E element); - adds element to the end of the list making new element the tail of list, if list is empty new element is assigned as head and tail

void add(E element, int index); - adds element at the specified index, if index is 0 new element is assigned as head and refers to previous head, 
if index is equal to size add(E element) method is called

E get(int index); - returns element at the specified index

boolean remove(E element); - finds first occurence of the element from the list making it current node and deletes it by assigning previous node's "next pointer" to the node after current node and assigning "previous pointer" of the node after current node to previous node,
if element is head - node after head will be assigned as new head and pointer to previous will be assigned to null,
if element is tail - node before tail will be assigned as new tail and pointer to next will be assigned to null

E remove(int index); - deletes element at specified index by storing element using get(int index) method and caling boolean remove(E element) method

int size(); - returns the size of list

boolean contains(Object o); - checks if list contains specified element, if yes returns true and vice versa

void clear(); - deletes all elements from the list by assigning head and tail of the list to null

int indexOf(Object o); - finds index of first occurence of the specified element and returns index, if not found returns -1

int lastIndexOf(Object o); -finds index of last occurence of the specified element and returns index, if not found returns -1


*both classes provide iterator*
