<!--<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<nav class="navbar navbar-inverse" style="background:#292d39;">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/item">Item</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/model">Model</a></li>
					<li><a href="/admin/color">Color</a></li>
					<li ><a href="/admin/country">Country</a></li>
					<li><a href="/admin/season">Season</a></li>
					<li  class="active"><a href="/admin/content">Content</a><span	class="sr-only">(current)</span></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12">
		
	</div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/content" method="POST" modelAttribute="content">
					<div class="form-group">
    					<label for="content" class="col-sm-2 control-label">Content</label>
    					<div class="col-sm-10">
    					<form:textarea type="text" class="form-control"  path="name" id="content" rows="3"></form:textarea>
      					
    					</div>
    					
  					</div>
  					
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8 col-xs-8"><h3>Content </h3></div>
			<div class="col-md-2 col-xs-2"><h3>Update</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${page.content}" var="content">
				<div class="row">
					<div class="col-md-4 col-xs-4">${content.name}</div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="/admin/content/update/${content.id}<custom:allParams/>">update</a></div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="/admin/content/delete/${content.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12">
	<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>-->