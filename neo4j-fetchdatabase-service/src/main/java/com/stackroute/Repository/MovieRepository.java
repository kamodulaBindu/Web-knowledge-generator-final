package com.stackroute.Repository;
import com.stackroute.model.Movie;
import com.stackroute.model.Node;
import com.stackroute.model.Node1;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import java.util.Collection;

public interface MovieRepository extends Neo4jRepository<Movie,Long> {
    //Getting data for one hobbe
    @Query("With :#{#node} AS data\n"+
            "MATCH (connected)-[r]->(m)\n " +
            "WHERE (data.node1 in labels(connected) AND m[{key}]=data.value1) \n" +
            "RETURN connected as name")
    Collection<Node> findData(@Param("node") Node1 node,@Param("key") String key);
    @Query("With :#{#node} AS data\n"+
            "MATCH (m)-[r]->(connected)\n"+
            "WHERE (m[{key}]=data.value1)\n" +
            "RETURN connected as name")
    Collection<Node> suggestions1(@Param("node") Node1 node,@Param("key") String key);
    @Query("With :#{#node} AS data\n" +
            "MATCH (connected)-[r1]->(m),(connected)-[r2]->(p)\n" +
            "WHERE (data.node1 in labels(connected) AND m[{key1}]=data.value1 AND p[{key2}]=data.value2)\n" +
            "RETURN connected as name")
    Collection<Node> findData2(@Param("node") Node1 node,@Param("key1") String key1,@Param("key2") String key2);
    @Query("With :#{#node} AS data\n" +
            "MATCH (connected)-[r1]->(m),(connected)-[r2]->(p),(connected)-[r3]->(n)\n" +
            "WHERE (data.node1 in labels(connected) AND m[{key1}]=data.value1 AND p[{key2}]=data.value2 AND n[{key3}]=data.value3)\n" +
            "RETURN connected as name")
    Collection<Node> findData3(@Param("node") Node1 node,@Param("key1") String key1,@Param("key2") String key2,@Param("key3") String key3);


}







