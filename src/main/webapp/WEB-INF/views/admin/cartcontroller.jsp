<%@ page language="java" contentType="text/html; charset=UTF-8"
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
					<li ><a href="/admin/category">Category</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/model">Model</a></li>
					<li><a href="/admin/color">Color</a></li>
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/season">Season</a></li>
					<li class="active"><a href="/admin/cartcontroller">ShopCart</a><span	class="sr-only">(current)</span></li>
					</ul>
			</div>
		</div>
	</nav>
</div>

<div class="row">

	<div class="col-md-12 col-xs-12">
		<div class="row">
			<div class="col-md-2 col-xs-2"><h3>User name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Phone number</h3></div>
				<div class="col-md-6 col-xs-6">
				<div class="col-md-12 col-xs-12"><h3>Item</h3></div>
				<div class="col-md-12 col-xs-12">
				<div class="col-md-2 col-xs-2">
								<h3>Producer</h3>
							</div>
							<div class="col-md-2 col-xs-2">
								<h3>Model</h3>
							</div>
							<div class="col-md-2 col-xs-2">
								<h3>Price</h3>
							</div>
							<div class="col-md-1 col-xs-1">
								<h3>Size</h3>
							</div>
							<div class="col-md-2 col-xs-2">
								<h3>Color</h3>
							</div>
							<div class="col-md-1 col-xs-1">
								<h3>Season</h3>
							</div>
							<div class="col-md-2 col-xs-2">
								<h3>Category</h3>
							</div>
				</div>
				</div>
			<div class="col-md-2 col-xs-2"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${users}" var="user">
				<div class="row" style="background:white; border-top:1px solid #f4f4f4;">
					<div class="col-md-2 col-xs-2" style="border-right:1px solid #f4f4f4;"><h3>${user.username}</h3></div>
					<div class="col-md-2 col-xs-2" style="border-right:1px solid #f4f4f4;"><h3>${user.phoneNumber}</h3></div>
					<div class="col-md-6 col-xs-6">
						
							<c:forEach items="${user.items}" var="item">
							<div class="col-md-12 col-xs-12" style="padding:0px; border-top:1px solid #f4f4f4;">
							<div class="col-md-2 col-xs-2">
								<h3>${item.producer.name}</h3>
							</div>
							<div class="col-md-2 col-xs-2">
								<h3>${item.model.name}</h3>
							</div>
							<div class="col-md-2 col-xs-2">
								<h3>${item.price}</h3>
							</div>
							<div class="col-md-1 col-xs-1">
								<h3>${item.size}</h3>
							</div>
							<div class="col-md-2 col-xs-2">
								<h3>${item.color.name}</h3>
							</div>
							<div class="col-md-1 col-xs-1">
								<h3>${item.season.name}</h3>
							</div>
							<div class="col-md-2 col-xs-2">
								<h3>${item.category.name}</h3>
							</div>
								</div>
							</c:forEach>
					</div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-danger" href="/admin/cartcontroller/delete/${user.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>

</div>
