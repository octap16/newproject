<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ page import="ua.entity.*" %>
<style>
	#filter>.form-group>.col-sm-12>span{
		display: block;
		padding-right:5px;
	}
</style>
<div class="row">
						<div class="col-md-12  "  style="padding:0 16% 0 14%;">
						
							<div class="col-md-9  col-md-push-3">
								<nav class="navbar navbar-inverse" style="margin:-1px 2px 0px 0px; background:#292d39;">
									<div class="container-fluid">
									<div class="navbar-header navbar-right" >
													<button type="button" class="navbar-toggle colapsed" data-toggle="collapse" data-target="#one">
														<span class="sr-only">Navigation</span>
														<span class="icon-bar"></span>
														<span class="icon-bar"></span>
														<span class="icon-bar"></span>
									
													</button>
													<div class="header_cart" >
															<a href="/shoppingcart/">
															<i class="fa fa-shopping-cart"></i>
															<span id ="cart_items">Кошик </span>
															</a>
														</div>		
									</div>
										<div class="collapse navbar-collapse" id="one" >
											<ul class="nav navbar-nav" style="padding-top: 5px;" >
												<li class="megamenu_item">
													<a href="/">ГОЛОВНА</a>
												</li>
												
												<li class="megamenu_item">
													<a href="#">РОЗПРОДАЖ</a>
												</li>
												
												<li class="megamenu_item">
													<a href="#">КОНТАКТИ</a>
												</li>
												
												<li class="megamenu_item">
													<a href="https://novaposhta.ua/">ОПЛАТА І ДОСТАВКА</a>
												</li>
												
											</ul>
													
										</div>
										
									</div>
									
								</nav>
														
						</div>
						<div class=" col-md-3  col-md-pull-9"   >
							<h3 class="widget_header" style="margin: 0 -5px 0 -4px;" >
							Категорії
							</h3>
						</div>
						</div>
					</div>
					<section>
				<div class="container-fluid" style="padding:0 14%;  ">
					<div class="row">
					<div class="sidebar col-md-3 ">
						
						<div class="widget_content" >
						<form:form class="form-horizontal" action="/filters" method="GET" modelAttribute="filter" id="filter">
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
					<h4>Колір</h4>
						<form:checkboxes items="${colors}" path="colorIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group" style="background:white;">
					<div class="col-sm-12">
					<h4>Виробник</h4>
						<form:checkboxes items="${producers}" path="producerIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group" style="background:white;">
					<div class="col-sm-12">
					<h4>Модель</h4>
						<form:checkboxes items="${models}" path="modelIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
			<div class="form-group" style="background:white;"> 
					<div class="col-sm-12">
					<h4>Сезон</h4>
						<form:checkboxes items="${seasons}" path="seasonIds" itemLabel="name" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
    				<div class="col-sm-12">
      					<button type="submit" class="btn btn-primary">Шукати</button>
    				</div>
  				</div>
			</form:form>
						</div>
					</div>
					<% Item item = new Item();%>
					<div class="main_content col-md-9 " style="padding-top:30px;" >
								<div class="col-md-3  col-md-offset-9">
								<div class="row">
									<div class="col-md-6 col-xs-6 text-center">
										<div class="dropdown">
											<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<custom:sort innerHtml="Name asc" paramValue="producer.name"/>
												<custom:sort innerHtml="Name desc" paramValue="producer.name,desc"/>
												<custom:sort innerHtml="Price asc" paramValue="price"/>
												<custom:sort innerHtml="Price asc" paramValue="price,desc"/>
											</ul>
										</div>
									</div>
									<div class="col-md-6 col-xs-6 text-center">
										<custom:size posibleSizes="3,6,9" size="${page.size}" />
									</div>
								</div>
							</div>
							<div class="row">
							<div class="main_content col-md-12 "  >
						<c:forEach items="${page.content}" var="item">
							<div class="product col-md-3" style="float:left; background:#fff; list-style:none; position:relative;  margin: 2% 2% 0 0;  width:240px;">
								<div class="product_wrapper">
									<div class="product_img">
									<a class="imd change" href="/info/${item.id}">
									<img class="img-rounded" width="100%" src="/images/item/${item.id}.jpg?version=${item.version}">
									</a>
									</div>
									<div class="product_info">
									<div class="product_price">${item.price}<span class="price">грн</span></div>
									<div class="product_price">${item.producer.name} <span class="product_name">${item.model.name}</span></div>
									
									<div class="product_desc product_desc_short" style="height: 85px; overflow: hidden;text-overflow: ellipsis;">${item.context}</div>
									<div class="product_links">
										<a href="/filters/ordernow/${item.id}">
										<button class ="btn btn-card" type="submit">
										<i class="fa fa-shopping-cart"></i>
										</button>
										</a>
										<a class="btn" href="/info/${item.id}">
										<i class="fa fa-eye"></i>
										</a>
									</div>	
									</div>
								</div>
							</div>
							
						</c:forEach>
						</div>
						</div>
					</div>
					</div>
				</div>
		<div class="col-md-12 col-xs-12 text-center" style="background: #f4f4f4;">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
		</section>
