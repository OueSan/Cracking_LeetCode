class Solution {
public:
    int maxProfit(vector<int>& inventory, int orders) {
        int n = inventory.size();
        
        long long ans = 0;
        long long mod = 1e9 + 7;
        sort(inventory.begin(),inventory.end());
        long long curr = inventory.back();
        int lst = n-2;
        long long tt = 1;

        while(orders){
            
            while(lst >= 0 && inventory[lst] == curr){
                lst--;
            }
            tt = n - lst - 1;

            if(lst == -1){
                if(orders < tt){
                    ans = (ans + orders*curr )%mod;
                    orders = 0;
                    break;
                }
                else {

                    long long cango = (curr - orders/tt)%mod ;
                    int add = (mod + (curr*(curr + 1))/2 - (cango*(cango + 1))/2)%mod;
                    ans = (ans + tt*(add))%mod;
                    curr = cango;
                    orders%=tt;

                }
                continue;
            }

            if(orders < tt){

                ans = (ans + orders*curr )%mod;
                orders = 0;
                break;

            }
            else {              

                long long cango = inventory[lst];
                cango = max(cango , curr - orders/tt);     

                int add = (mod + (curr*(curr + 1))/2 - (cango*(cango + 1))/2)%mod;
                ans = (ans + tt*(add))%mod;
                orders-=(tt*(curr-cango));
                curr = cango;

            }


        }

        return (int)ans;
    }
};