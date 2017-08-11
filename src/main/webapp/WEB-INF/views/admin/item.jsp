<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<style>
	#filter>.form-group>.col-sm-12>span{
		display: block;
	}
</style>
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
					<li class="active"><a href="/admin/item">Item</a><span	class="sr-only">(current)</span></li>
					<li><a href="/admin/category">Category</a></li>
					<li ><a href="/admin/producer">Producer</a></li>
					<li ><a href="/admin/model">Model</a></li>
					<li><a href="/admin/color">Color</a></li>
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/season">Season</a></li>
					<li><a href="/admin/cartcontroller">ShopCart</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12" >
		
			<form:form class="form-horizontal" action="/admin/item" method="GET" modelAttribute="filter" id="filter">
				<custom:hiddenInputs excludeParams=" minPrice, maxPrice, minc, maxSize, categoryIds, colorIds, modelIds, producerIds, seasonIds " excludeParamsPrefix="specDigitFilters"/>
				
				<div class="form-group" >
					<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="minPrice" placeholder="Min price"/>
	    			</div>
	    			<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="maxPrice" placeholder="Max price"/>
	    			</div>
				</div>
				<div class="form-group">
					<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="minSize" placeholder="Min size"/>
	    			</div>
	    			<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="maxSize" placeholder="Max size"/>
	    			</div>
				</div>
				<div class="form-group" style="background:white;">
					<div class="col-sm-12">
					<h4>Category</h4>
						<form:checkboxes items="${categories}" path="categoryIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group" style="background:white;">
					<div class="col-sm-12">
					<h4>Color</h4>
						<form:checkboxes items="${colors}" path="colorIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group" style="background:white;">
					<div class="col-sm-12">
					<h4>Model</h4>
						<form:checkboxes items="${models}" path="modelIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group" style="background:white;">
					<div class="col-sm-12">
					<h4>Producer</h4>
						<form:checkboxes items="${producers}" path="producerIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group" style="background:white;"> 
					<div class="col-sm-12">
					<h4>Season</h4>
						<form:checkboxes items="${seasons}" path="seasonIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
    				<div class="col-sm-12">
      					<button type="submit" class="btn btn-primary">Search</button>
    				</div>
  				</div>
			</form:form>
		
	</div>
	<div class="col-md-7 col-xs-12">
	<div class="col-md-12 col-xs-12">
	<div class="col-md-9 col-xs-12">
			
				<form:form class="form-horizontal" action="/admin/item" method="POST" modelAttribute="item" enctype="multipart/form-data">
				<custom:hiddenInputs excludeParams="category,  producer, size, price, color, season, model" excludeParamsPrefix="specificationDigitals"/>
				
				<div class="form-group">
    					<label for="categoryId" class="col-sm-2 control-label">Category</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="category" id="categoryId" items="${categories}" itemValue="id" itemLabel="name"/>
      					</div>
  					</div>
  					<div class="form-group">
    					<label for="producerId" class="col-sm-2 control-label">Producer</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="producer" id="producerId" items="${producers}" itemValue="id" itemLabel="name"/>
      					</div>
  					</div>
					<div class="form-group">
    					<label for="modelId" class="col-sm-2 control-label">Model</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="model" id="modelId" items="${models}" itemValue="id" itemLabel="name"/>
      					</div>
  					</div>
					<div class="form-group">
    					<label for="colorId" class="col-sm-2 control-label">Color</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="color" id="colorId" items="${colors}" itemValue="id" itemLabel="name"/>
      					</div>
  					</div>
  					<div class="form-group">
    					<label for="seasonId" class="col-sm-2 control-label">Season</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="season" id="seasonId" items="${seasons}" itemValue="id" itemLabel="name"/>
      					</div>
  					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Size</label>
  						<div class="col-sm-10">
  							<form:input path="size" class="form-control"/>
  						</div>
  					</div>
  					<div class="form-group">
							<label for="size" class="col-sm-offset-2 col-sm-10"><form:errors path="size"/></label>
					</div>
  					<div class="form-group">
  						<label class="col-sm-2 control-label">Price</label>
  						<div class="col-sm-10">
  							<form:input path="price" class="form-control"/>
  						</div>
  					</div>
  					<div class="form-group">
							<label for="price" class="col-sm-offset-2 col-sm-10"><form:errors path="price"/></label>
					</div>
					<div class="form-group">
  						<label class="col-sm-2 control-label">Context</label>
  						<div class="col-sm-10">
  							
  							<form:textarea class="form-control" rows="5" path="context"></form:textarea>
  						</div>
  						<div class="form-group">
							<label for="context" class="col-sm-offset-2 col-sm-10"><form:errors path="context"/></label>
					</div>
  					</div>
					<div class="form-group">
  						<div class="col-sm-offset-2 col-sm-10">
		  					<label class="btn btn-default btn-file">
		        				Browse <input type="file" name="file" style="display: none;">
		    				</label>
	    				</div>
	    					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Create</button>
    					</div>
  					</div>
				</form:form>
			
		</div>
		
		<div class="col-md-3 col-xs-12">
		<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name"/>
						<custom:sort innerHtml="Name desc" paramValue="name,desc"/>
						<custom:sort innerHtml="Price asc" paramValue="price"/>
						<custom:sort innerHtml="Price asc" paramValue="price,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
	</div>
		<div class="row">
		<div class="col-md-12 col-xs-12" style="padding: 0px;">
			<div class="col-md-2 col-xs-2"><h4>Image</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Producer</h4></div>
			<div class="col-md-1 col-xs-1"><h4 style="text-align: center">Model</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Category</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Color</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Season</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Size</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Price</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Context</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Update</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Delete</h4></div>
			</div>
			</div>
		<div class="row">
		<div class="col-md-12 col-xs-12">
			<c:forEach items="${page.content}" var="item">
				<div class="row">
				<div style="border-bottom:1px solid #9E9E9E; ">
					<div class="col-md-2 col-xs-2"><img class="img-rounded" width="100%" src="/images/item/${item.id}.jpg?version=${item.version}"></div>
					<div class="col-md-1 col-xs-1">${item.producer.name}</div>
					<div class="col-md-1 col-xs-1">${item.model.name}</div>
					<div class="col-md-1 col-xs-1">${item.category.name}</div>
					<div class="col-md-1 col-xs-1">${item.color.name}</div>
					<div class="col-md-1 col-xs-1">${item.season.name}</div>
					<div class="col-md-1 col-xs-1">${item.size}</div>
					<div class="col-md-1 col-xs-1">${item.price}</div>
					<div class="col-md-1 col-xs-1">
						<a href="#1${item.id}" class="btn btn-primary" data-toggle="modal" style="margin-top: 3px;">Context</a>  
							<!-- HTML-код модального окна -->
							<div id="1${item.id}" class="modal fade">
							  <div class="modal-dialog">
							    <div class="modal-content">
							      <!-- Заголовок модального окна -->
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							        <h4 class="modal-title">Context</h4>
							      </div>
							      <!-- Основное содержимое модального окна -->
							      <div class="modal-body">
							       ${item.context}
							      </div>
							      <!-- Футер модального окна -->
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							       
							      </div>
							    </div>
							  </div>
							</div>
					</div>
					<div class="col-md-1 col-xs-1" style="margin-top:3px;"><a class="btn btn-warning" href="/admin/item/update/${item.id}<custom:allParams/>">update</a></div>
					<div class="col-md-1 col-xs-1" style="margin-top:3px;"><a class="btn btn-danger" href="/admin/item/delete/${item.id}<custom:allParams/>">delete</a></div>
					</div>
				</div>
			</c:forEach>
			</div>
			</div>
			
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>
