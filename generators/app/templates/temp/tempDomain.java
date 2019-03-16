package com.bee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * created by guos on 2018/11/2
 */
@Entity
@Table(name = "t_<%=name%>")
public class <%= upName %> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

<% for(var i in fields){ %>
    public <%= fields[i].type %> <%= fields[i].name %>;
<% } %>
   
<% for(var i in fields){ %>
    public <%= fields[i].type %> get<%= fields[i].upName %>(){
        return <%= fields[i].name %>;
    }

    public void set<%= fields[i].upName %>(<%=fields[i].type %> <%= fields[i].name %>){
        this.<%= fields[i].name %> = <%= fields[i].name %>;
    }
<% } %>


}
