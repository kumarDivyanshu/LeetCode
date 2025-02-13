class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        priority_queue<long, vector<long>, greater<long>> pq(nums.begin(), nums.end());
        int count = 0;
        while(pq.top() < k){
            long x = pq.top();
            pq.pop();
            long y = pq.top();
            pq.pop();
            long long z = std::min(x,y)*2 + std::max(x,y);
            pq.push(z);
            count++;
        }
        return count;
    }
};