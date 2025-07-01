class MyCalendar {
    using int2 = pair<int, int>;
    set<int2> S;
public:
    MyCalendar() { }
    
    bool book(int start, int end) {
        auto it=S.lower_bound({start, -1});
        
        // overlap with the next interval
        if (it != S.end() && (*it).first<end) 
            return 0;
        
        
        // overlap with the previous interval
        if (it != S.begin() && (*prev(it)).second > start) 
            return 0;
        
        
        // No overlap, insert the new booking
        S.insert({start, end});
        return 1;
    }
};