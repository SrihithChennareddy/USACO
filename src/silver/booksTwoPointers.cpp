#include <bits/stdc++.h>
using namespace std;

using ll = long long;

using vi = vector<int>;
#define pb push_back
#define all(x) begin(x), end(x)
#define sz(x) (int) (x).size()

using pi = pair<int,int>;
#define f first
#define s second
#define mp make_pair

void setIO(string name = "") {
	cin.tie(0)->sync_with_stdio(0); 
	if (sz(name)) {
		freopen((name + ".in").c_str(), "r", stdin);
		freopen((name + ".out").c_str(), "w", stdout);
	}
}

int main(){
    setIO();
    int n, t;
    cin >> n >> t;
 
    std::vector<int> books(n, 0);
     
    for(int i=0; i<n; i++){
        cin >> books[i];
    }
     
    int mlen = 0;
    int sum=0;
    int left=0, right=0;
    while(left<n && right<n){
        while(right<n){
            sum += books[right++];
            if(sum > t) {
                sum -= books[--right];
                break;
            }
        }
        mlen = max(mlen,right-left);
        sum -= books[left++];
    }

    cout << mlen; 
}