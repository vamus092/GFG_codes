class Solution {
public:
    vector<vector<int>> buildMatrix(int k, vector<vector<int>>& rowConditions,
                                    vector<vector<int>>& colConditions) {
        vector<int> orderRows = topoSort(rowConditions, k);
        vector<int> orderColumns = topoSort(colConditions, k);

        if (orderRows.empty() or orderColumns.empty())
            return {};

        vector<vector<int>> matrix(k, vector<int>(k, 0));
        vector<int> colIndices(k + 1);
        for (int i = 0; i < k; i++) {
            colIndices[orderColumns[i]] = i;
        }
        for (int i = 0; i < k; i++) {
            matrix[i][colIndices[orderRows[i]]] = orderRows[i];
        }
        return matrix;
    }

private:
    vector<int> topoSort(vector<vector<int>>& edges, int n) {
        vector<vector<int>> adj(n + 1);
        vector<int> order;
        vector<int> visited(n + 1, 0); // 0: not visited, 1: visiting, 2: visited
        bool hasCycle = false;

        // Build adjacency list
        for (auto& x : edges) {
            adj[x[0]].push_back(x[1]);
        }

        // Perform DFS for each node
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited, order, hasCycle);
                if (hasCycle) return {}; // Return empty if cycle detected
            }
        }

        reverse(order.begin(), order.end()); // Reverse to get the correct order
        return order;
    }

    void dfs(int node, vector<vector<int>>& adj, vector<int>& visited, vector<int>& order, bool& hasCycle) {
        visited[node] = 1; // Mark node as visiting
        for (int neighbor : adj[node]) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, adj, visited, order, hasCycle);
                if (hasCycle) return; // Early exit if a cycle is detected
            } else if (visited[neighbor] == 1) {
                hasCycle = true; // Cycle detected
                return;
            }
        }
        visited[node] = 2; // Mark node as visited
        order.push_back(node); // Add node to the order
    }
};
