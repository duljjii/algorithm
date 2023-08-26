from collections import deque
import sys
input = sys.stdin.readline
R, C = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(R)]
q = deque([(0, 0)])
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
visited = [[False] * C for _ in range(R)]


def bfs():
    if not q :
        return False
    while q:
        r, c = q.popleft()
        visited[r][c] = True
        board[r][c] = 3
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if 0 <= nr < R and 0 <= nc < C and board[nr][nc] == 0 and visited[nr][nc] == False:
                q.append((nr, nc))
                visited[nr][nc] = True
                board[nr][nc] = 3

    return True


def c_bfs(r, c):
    c_visited = [[False] * C for _ in range(R)]
    c_q = deque([(r, c)])
    c_visited[r][c] = True

    while c_q:
        r, c = c_q.popleft()
        cnt = 0
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]
            if 0 <= nr < R and 0 <= nc < C and board[nr][nc] == 1 and c_visited[nr][nc] == False:
                c_visited[nr][nc] = True
                c_q.append((nr, nc))
            if 0 <= nr < R and 0 <= nc < C and board[nr][nc] == 3:
                cnt += 1
        if cnt > 1 :
            q.append((r, c))
day = 0
while bfs() :
    for i in range(R):
        for j in range(C):
            cnt = 0
            if board[i][j] == 1 :
                for d in range(4):
                    ni = i + dr[d]
                    nj = j + dc[d]
                    if 0 <= ni < R and 0 <= nj < C and board[ni][nj] == 3:
                        cnt += 1
                        if cnt == 2 :
                            q.append((i, j))
                            break
    day += 1

print(day-1)
