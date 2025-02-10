#include <bits/stdc++.h>
using namespace std;

int main() {
    freopen("bcount.in","r",stdin);
    freopen("bcount.out","w",stdout);
	int N, Q;
	cin >> N >> Q;
    vector<vector<int>> nums(N+1, vector<int>(3, 0));
	for(int i=1; i<=N; i++){
        int x; 
        cin >> x;
        nums[i][0] = (x==1) ? nums[i-1][0] + 1 : nums[i-1][0]; 
        nums[i][1] = (x==2) ? nums[i-1][1] + 1 : nums[i-1][1]; 
        nums[i][2] = (x==3) ? nums[i-1][2] + 1 : nums[i-1][2]; 
    }
	for (int i = 0; i < Q; ++i) {
		int l, r;
		cin >> l >> r;
        cout << nums[r][0]-nums[l-1][0] << " ";
        cout << nums[r][1]-nums[l-1][1] << " ";
        cout << nums[r][2]-nums[l-1][2] << "\n";
	}
}