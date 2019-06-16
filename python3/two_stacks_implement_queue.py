class Queue:
    """two_stacks_implement_queue"""
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def append_queue_tail(self, n):        
        self.stack1.append(n)

    def remove_head(self):
        if len(self.stack2) == 0:
            while len(self.stack1) > 0:
                self.stack2.append(self.stack1.pop())

        # even stack 1 is empty
        if len(self.stack2) == 0:
            return None

        return self.stack2.pop()


q = Queue()
print(q.remove_head())
q.append_queue_tail(1)
q.append_queue_tail(2)
q.append_queue_tail(3)
print(q.remove_head())
print(q.remove_head())
print(q.remove_head())
