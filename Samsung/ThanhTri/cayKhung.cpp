#include <iostream>
using namespace std;

int m;
int map[110][110];
int u[110];

int soMayBanDa;

void printMap();
void resetMap();
void printList();

int list[110];
int lengthOfList;
bool visited[110][110];
bool removed[110];

void removeMinEdges() {
	int min = 100100100;
	int vtMin = -1;
	for(int i = 0; i < lengthOfList - 1; i++) {
		int f = list[i];
		int t = list[i + 1];

		if(u[f] + u[t] < min) {
			min = u[f] + u[t];
			vtMin = i;
		}
	}

	int f = list[vtMin];
	int t = list[vtMin + 1];
	map[f][t] = 0; map[t][f] = 0;

	soMayBanDa += min;
}

void find(int current, int start) {
	if(current == start && lengthOfList > 1) {
		// printList();
		removeMinEdges();

		return;
	}

	for(int i = 0; i < m; i++) {
		if(map[current][i] == 1 && visited[current][i] == false) {
			removed[i] = true;

			visited[current][i] = true; visited[i][current] = true;
			list[lengthOfList] = i;

			lengthOfList++;
			find(i, start);
			lengthOfList--;

			visited[current][i] = false; visited[i][current] = false;
		}
	}

}

int main() {
	freopen("input.txt", "r", stdin);

	int T;
	cin >> T;

	for(int t = 0; t < T; t++) {
		cin >> m;
		resetMap();

		for(int i = 0; i < m; i++) {
			int f; cin >> f;
			removed[f] = false;

			cin >> u[f];

			int length; cin >> length;
			for(int j = 0; j < length; j++) {
				int t; cin >> t;
				map[f][t] = 1;
			}
		}

		soMayBanDa = 0;
		for(int i = 0; i < m; i++) {
			if(removed[i] == false) {
				removed[i] = true;

				list[0] = i;
				lengthOfList = 1;

				find(i, i);
			}
		}

		cout << soMayBanDa << endl;
	}
}






