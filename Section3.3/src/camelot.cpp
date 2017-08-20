/*
 ID: htluand1
 TASK: camelot
 LANG: C++
 */

#include <cstdio>
#include <cstring>
#include <cmath>
#include <algorithm>
#include <queue>
using namespace std;

const int MAXN = 26, MAXM = 40, INF = 20000;
const int DX[8] = {-2, -2, -1, -1, +1, +1, +2, +2},
     DY[8] = {-1, +1, -2, +2, -2, +2, -1, +1};
struct Node {
     int x, y;
     bool k;
     Node(int px, int py, bool pk) {
          x = px; y = py; k = pk;
     }
};
int N, M;
int dis[MAXN][MAXM][2], kdis[MAXN][MAXM];
int cost[MAXN][MAXM], kcost[MAXN][MAXM];

//类似spfa……
bool inq[MAXN][MAXM][2];
void bfs(int px, int py)
{
     memset(inq, 0, sizeof(inq));
     for (int i = 0; i < N; i++)
          for (int j = 0; j < M; j++)
               dis[i][j][0] = dis[i][j][1] = INF;
     queue<Node> q;
     q.push(Node(px, py, 0)); dis[px][py][0] = 0;
     while (!q.empty()) {
          Node u = q.front(); q.pop();
          inq[u.x][u.y][u.k] = false;
          int udis = dis[u.x][u.y][u.k];
          for (int i = 0; i < 8; i++) {
               Node v(u.x + DX[i], u.y + DY[i], u.k);
               if (v.x < 0 || v.x >= N || v.y < 0 || v.y >= M) continue;
               if (dis[v.x][v.y][v.k] > udis + 1) {
                     dis[v.x][v.y][v.k] = udis + 1;
                     if (!inq[v.x][v.y][v.k]) {
                          q.push(v); inq[v.x][v.y][v.k] = true;
                     }
               }
          }
          if (!u.k && dis[u.x][u.y][1] > udis + kdis[u.x][u.y]) {
               dis[u.x][u.y][1] = udis + kdis[u.x][u.y];
               if (!inq[u.x][u.y][1]) {
                    q.push(Node(u.x, u.y, 1)); inq[u.x][u.y][1] = true;
               }
          }
     }
}

int main()
{
     freopen("camelot.in", "r", stdin);
     freopen("camelot.out", "w", stdout);
     scanf("%d %d", &M, &N);
     int px, py;
     char inp[5];
     scanf("%s %d", inp, &py); px = inp[0] - 'A'; py--;
     for (int i = 0; i < N; i++)
          for (int j = 0; j < M; j++)
               kcost[i][j] = kdis[i][j] = max(abs(px - i), abs(py - j));

     while (scanf("%s%d", inp, &py) == 2) {
          px = inp[0] - 'A'; py--;
          bfs(px, py);
          for (int i = 0; i < N; i++)
               for (int j = 0; j < M; j++) {
                    cost[i][j] += dis[i][j][0];
                    kcost[i][j] = min(kcost[i][j], dis[i][j][1] - dis[i][j][0]);
               }
      }
     int ans = INF;
     for (int i = 0; i < N; i++)
          for (int j = 0; j < M; j++)
               ans = min(ans, cost[i][j] + kcost[i][j]);

     printf("%d\n", ans);
     fclose(stdin); fclose(stdout);
     return 0;
}
