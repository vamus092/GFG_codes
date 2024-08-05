class Solution {
public:
    std::string kthDistinct(std::vector<std::string>& arr, int k) {
        std::unordered_map<std::string, int> counts;
        std::vector<std::string> distinctOrder;

        for (const auto& elem : arr) {
            counts[elem]++;
        }

        for (const auto& elem : arr) {
            if (counts[elem] == 1) {
                distinctOrder.push_back(elem);
            }
        }

        if (k > 0 && k <= distinctOrder.size()) {
            return distinctOrder[k - 1]; 
        }

        return "";
    }
};
