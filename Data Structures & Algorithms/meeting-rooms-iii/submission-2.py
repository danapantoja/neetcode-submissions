class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
    
        available = [i for i in range(n)] # heap
        rooms = [0] * n #list
        used = [] # (endtime, room) heap
        
        meetings.sort(key=lambda x: x[0])
        for meeting in meetings:

            # free all available rooms
            while used and meeting[0] >= used[0][0]:
                heapq.heappush(available, heapq.heappop(used)[1])

            if available:
                room = heapq.heappop(available)
                heapq.heappush(used, [meeting[1], room])
                rooms[room] =  rooms[room]+1

            else:
                closest = heapq.heappop(used)
                wait_time = closest[0] - meeting[0]
                room = closest[1]
                heapq.heappush(used, [meeting[1] + wait_time, room])
                rooms[room] =  rooms[room]+1
            

        max_used = max(rooms)

        for i, room in enumerate(rooms):
            if room==max_used:
                return i
        
