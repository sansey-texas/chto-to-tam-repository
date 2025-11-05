#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

void generateHelper(vector<char>& chars, int start, vector<string>& result) {
    if (start == chars.size() - 1) {
        result.push_back(string(chars.begin(), chars.end()));
        return;
    }
    
    for (int i = start; i < chars.size(); i++) {
        swap(chars[start], chars[i]);
        generateHelper(chars, start + 1, result);
        swap(chars[start], chars[i]); // backtrack
    }
}

vector<string> generatePermutations(const string& str) {
    vector<string> result;
    vector<char> chars(str.begin(), str.end());
    generateHelper(chars, 0, result);
    return result;
}

int main() {
    string input = "abc";
    vector<string> permutations = generatePermutations(input);
    
    cout << "Перестановки строки \"" << input << "\":" << endl;
    for (const string& perm : permutations) {
        cout << perm << endl;
    }
    
    return 0;
}