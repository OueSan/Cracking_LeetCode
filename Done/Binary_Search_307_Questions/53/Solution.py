class MyCalendarTwo:
    def __init__(self):
        # Dictionary to hold the events
        self.events = defaultdict(int)

    def book(self, start: int, end: int) -> bool:
        # Increment start by +1 (start of booking)
        self.events[start] += 1
        # Decrement end by -1 (end of booking)
        self.events[end] -= 1
        
        active_bookings = 0
        
        # Sweep through the events in chronological order
        for time in sorted(self.events.keys()):
            active_bookings += self.events[time]
            
            # If we have 3 or more overlapping bookings, it's a triple booking
            if active_bookings >= 3:
                # Revert the changes, as the booking is not valid
                self.events[start] -= 1
                self.events[end] += 1
                
                # Remove from dict if count reaches zero
                if self.events[start] == 0:
                    del self.events[start]
                if self.events[end] == 0:
                    del self.events[end]
                
                return False  # Booking failed
            
            if time > end:
                break  # No need to check further
        
        # Booking is successful if no triple booking is found
        return True