# make node clas for linked list
class Node:
    def __init__(self, key,val):
        self.key, self.val = key, val
        self.prev = self.next = None

class LRUCache:
    # initialize map and dummy nodes on both sides
    def __init__(self, capacity: int):
        self.cache = {}
        self.capacity =capacity

        self.left, self.right = Node(0,0), Node(0,0)
        self.left.next, self.right.prev = self.right, self.left
    # to remmove from the LINKED LIST, set prev.next to node.next and next.prev to node.prev
    def remove(self,node):
        prev, nxt = node.prev, node.next
        prev.next = nxt
        nxt.prev = prev
    def insert(self, node):
        # get the last node in the linked list (prev)
        prev, nxt = self.right.prev, self.right
        # set node prev to prev from linked list
        # set node next to dummy right node
        node.next = nxt
        node.prev = prev
        # do the same for the other nodes so they are doubly attached
        nxt.prev = node
        prev.next = node
        
    # to get from the linked list,
    def get(self, key: int) -> int:
        #first check if key in dict
        if key in self.cache:
            #call self.remove to remove from linked list
            self.remove(self.cache[key])
            # call self.insert to insert at the end
            self.insert(self.cache[key])
            return self.cache[key].val
        
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            # remove old value
            self.remove(self.cache[key])
        # *********** add node to cache
        self.cache[key] = Node(key,value)
        #insert at end
        self.insert(self.cache[key])
        # check if full capacity
        if len(self.cache) > self.capacity:
            lru = self.left.next
            self.remove(lru)
            del self.cache[lru.key]


        
