class Solution {
  public:
    int maxLength(string str) {
        // code here
        stack<pair<char,int>>st;
        stack<pair<int,int>>range;
        for(int i = 0; i < str.length(); i++)
        {
            if(str[i]=='(')
            {
                st.push(make_pair(str[i],i));
            }
            else
            {
                if(st.empty() || st.top().first==')')
                {
                    st.push(make_pair(str[i],i));
                }
                else
                {
                    int l = st.top().second;
                    int r = i;
                    st.pop();
                    while(!range.empty() && range.top().first>l && range.top().second < r)
                    {
                        range.pop();
                    }
                    if(!range.empty() && range.top().second+1 == l)
                    {
                        l = range.top().first;
                        range.pop();
                    }
                    range.push(make_pair(l,r));
                }
            }
        }
        int ans = 0;
        while(!range.empty())
        {
            int r = range.top().second - range.top().first +1;
            ans = max(ans,r);
            range.pop();
        }
        return ans;
    }
};
