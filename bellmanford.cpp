//http://www.wutianqi.com/blog/1912.html
#include <iostream>
using namespace std;
struct Edge{
	int u, v;
	int weight;
};
const int maxnum = 100;
const int maxint = 999999;
int dis[maxnum];
Edge edge[maxnum];
int source, nodenum, edgenum;

void init(){
	cin >> nodenum >> edgenum >> source;
	for(int i = 1; i <= nodenum; ++i){
		dis[i] = maxint;
	}
	dis[source] = 0;
	for(int i = 1; i <= edgenum; ++i){
		cin >> edge[i].u >> edge[i].v >> edge[i].weight;
		if(edge[i].u == source){
			dis[edge[i].v] = edge[i].weight;
		} 
	}
}

void relax(int u, int v, int weight){
	if(dis[u] + weight < dis[v]){
		 dis[v] = dis[u] + weight;
	}
}
bool bellmanford(){
	for(int i = 1; i <= nodenum - 1; ++i){
		for(int j = 1; j <= edgenum; ++j){
			relax(edge[j].u, edge[j].v, edge[j].weight);
		}
	}
	bool flag = 1;
	for(int i = 1; i <= edgenum; ++i){
		if(dis[edge[i].u] + edge[i].weight < dis[edge[i].v]){
			flag = 0;
			break;
		}
	}
	return flag;
}

int main(){
	init();
	if(bellmanford()){
		for(int i = 1; i <= nodenum; ++i){
			cout << dis[i] << endl;
		}
	}
	return 0;
}




