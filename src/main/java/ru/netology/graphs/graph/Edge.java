package ru.netology.graphs.graph;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class Edge {
    @NonNull
    private Integer headEnd;
    @NonNull
    private Integer tailEnd;
}
