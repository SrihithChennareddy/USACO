#include <bits/stdc++.h>
using namespace std;

int  a[1001][1001];

int main() {
    freopen("paintbarn.in", "r", stdin);
    freopen("paintbarn.out", "w", stdout);

    int N,K;
    cin >> N >> K;

    while(N--){
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        a[x1][y1]++;
        a[x1][y2]--;
        a[x2][y1]--;
        a[x2][y2]++;
    }
    int count=0;
    for(int i=0; i<1001; i++) {
        for(int j=0; j<1001; j++) {
            if(i) a[i][j] += a[i-1][j];
            if(j) a[i][j] += a[i][j-1];
            if(i && j) a[i][j] -= a[i-1][j-1];
            if(a[i][j]==K) count++;
        }
    }

   cout << count;

}