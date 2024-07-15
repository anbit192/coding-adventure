#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <algorithm>
#include <set>
#include <cassert>
using namespace std;

struct Node
{
    Node *next;
    Node *prev;
    int value;
    int key;
    Node(Node *p, Node *n, int k, int val) : prev(p), next(n), key(k), value(val){}; // another way to initalize called 'member initializer list'
    Node(int k, int val) : prev(NULL), next(NULL), key(k), value(val){};
};

class Cache
{
    protected:
        map<int, Node *> mp;            // map the key to the node in the linked list
        int cp;                         // capacity
        Node *tail;                     // double linked list tail pointer
        Node *head;                     // double linked list head pointer
        virtual void set(int, int) = 0; // set function
        virtual int get(int) = 0;       // get function

    protected:Node* find(Node* node, int key)
    {
        if (node == nullptr)
        {
            return nullptr;
        }
        else if (node->key == key)
        {
            return node;
        }
        else
        {
            return find(node->next, key);
        }
    } 

};

class LRUCache : public Cache
{
    
    public:LRUCache(int cp)
    {
        this->head = nullptr;
        this->tail = nullptr;
        this->cp = cp;
    }

    public:void set(int k, int val)
    {
        Node* temp = new Node(k, val);
        auto it = this->mp.find(k);

        if (!this->head) // first element insertion
        {
            // cout << "first element!" <<endl;
            this->head = temp;
            this->tail = temp;
            // ++this->cp;
        }
        if (it == this->mp.end()) // key does not exist in map
        {
            // cout << "Does not exist in map,..." <<endl;
            if (this->mp.size() < this->cp) // < capacity (swap to top after insertion)
            {

                temp->next = this->head;
                this->head->prev = temp;

                this->head = temp;
            }
            else // exceed capacity (replace the tail of current map)
            {
                Node* to_delete = this->tail;

                temp->prev = this->tail->prev;

                this->mp.erase(to_delete->key);
                delete to_delete;
        
                this->tail = temp;
            }
        }
        else if (it != this->mp.end())
        {
            // cout << "Does exist,.." <<endl;
            it->second->key = k;
            it->second->value = val;
        }

        this->mp[k] = temp;
        // ++this->cp;
    }

    private:void swapToTop(Node* node)
    {
        if (!(node))
        {
            return;
        }
        else if (node == this->head)
        {
            return;
        }
        else if (!this->head)
        {
            return;
        }
        

        Node* prev_node = node->prev;
        prev_node->next = node->next;

        this->head->prev = node;

        node->next = this->head;
        node->prev = nullptr;
        this->head = node;
    }

    public:int get(int k)
    {
        auto it = mp.find(k);
        if (it != this->mp.end())
        {
            // this->swapToTop(it->second);
            return this->mp[k]->value;
        }

        return -1;
    }
};


int main() {
   int n, capacity,i;
   cout << "Input n and capacity: " <<endl;
   cin >> n >> capacity;
   LRUCache l(capacity);
   for(i=0;i<n;i++) {
      string command;
      cout << "Input command and params: " <<endl;
      cin >> command;
      if(command == "get") {
         int key;
         cin >> key;
         cout << l.get(key) << endl;
      } 
      else if(command == "set") {
         int key, value;
         cin >> key >> value;
         l.set(key,value);
      }
   }
   return 0;
}