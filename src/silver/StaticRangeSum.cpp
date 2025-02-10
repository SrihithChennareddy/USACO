#include <bits/stdc++.h>
using namespace std;
int main(){
    int N,Q;
    cin >> N >> Q;
    vector<long> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    vector<long> pre(N+1);
    for(int i=0; i<N; i++){
        pre[i+1] = pre[i] + A[i];
    }
    for(int j=0; j<Q; j++){
        int l,r;
        cin >> l >> r;
        cout << pre[r] - pre[l] << "\n";
    }
    

}