#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

static int order = 0;

class Message {
  	private:string text;
	private:time_t order_sent;

  	public:Message() {}
	
	public:Message(const string& text) 
	{
		this->text = text;
		this->order_sent = order;
		++order;
	}
	
	public:const string& get_text() const { return this->text; }
	public:time_t get_order_sent()
	{
		return this->order_sent;
	}
		
	
	bool operator <(const Message &msg) const
	{
		return (this->order_sent < msg.order_sent);
	}
};


class MessageFactory {
  	public:MessageFactory() {}
	public:Message create_message(const string &text) 
	{
		return Message(text);
	}
};

class Recipient {
	
	private:vector<Message> messages_;
	
  	public:Recipient() {}
	public:void receive(const Message &msg) { messages_.push_back(msg); }
	public:void print_messages() {
		fix_order();
		for (auto &msg : messages_) {
			cout << msg.get_text() << endl;
		}
		messages_.clear();
	}

  	private:void fix_order() { sort(messages_.begin(), messages_.end()); }
};

class Network {
  
	public:static void send_messages(vector<Message> messages, Recipient &recipient) {
		// simulates the unpredictable network, where sent messages might arrive
		// in unspecified order
		random_shuffle(messages.begin(), messages.end());
		for (auto msg : messages) {
			recipient.receive(msg);
		}
	}
};

int main() {
	MessageFactory message_factory;
	Recipient recipient;
	vector<Message> messages;
	string text;
	while (std::getline(cin, text)) {
        if (text.empty()) {
            // cout << "Empty string detected, skipping." << endl;
            break;
        }
        messages.push_back(message_factory.create_message(text));
    }
	Network::send_messages(messages, recipient);
	recipient.print_messages();
}
