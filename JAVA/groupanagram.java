 void solve(Node* root, int k, int level,vector<Node*>& v,unordered_set<Node*>&s) {
        if(root == NULL) {
            return;
        }
        v.push_back(root);
      
        
        if(root->left == NULL && root->right == NULL && (level-k) >= 0) {
            Node* ele = v[level-k];
            if(s.count(ele) == 0) {
                s.insert(ele);    
            }
        }
        
        solve(root->left,k, level+1,v,s);
        solve(root->right,k, level+1,v,s);
        v.pop_back();
    }
    //Function to return count of nodes at a given distance from leaf nodes.
    int printKDistantfromLeaf(Node* root, int k)
    {
        //Add your code here. 
        unordered_set<Node*> s;
        int level = 0;
        vector<Node*> v;
        solve(root,k,level,v,s);
        /*for(auto x : s) {
            cout << x -> data << " ";
        }
        cout << endl;*/
        return s.size();
    }
};
