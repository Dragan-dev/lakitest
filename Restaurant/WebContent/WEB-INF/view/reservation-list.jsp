<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Reservation list</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
  <!-- jsGrid -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jsgrid/jsgrid.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jsgrid/jsgrid-theme.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
	<!-- Icon button style -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
        
          <button class="btn btn-navbar" type="submit">
          </button>
        </div>
      </div>
    </form>

    <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
       <li>
        <a class="notification" href="reservation-list">
  			<span>Unread Reservation</span>        
          <span class="badge" style="background-color: orange;" >${reservationCount}</span>
        </a>
        </li>
        <li>
        <a  class="notification" href="message-list">
  			<span>Unread Message</span>        
          <span class="badge" style="background-color:orange;">${messageCount}</span>
        </a>
        </li>
        </ul>
        </nav>
	  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="toFront" class="brand-link">
      <img src="${pageContext.request.contextPath}/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Restaurantly</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="${pageContext.request.contextPath}/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Alexander Pierce</a>
        </div>
      </div>

      
		<!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

          <li class="nav-item">
          <li class="nav-item">
            <a href="reservation-list" class="nav-link">
				<i class="fa fa-circle nav-icon"></i>
              <p>
                Reservation list
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="menu" class="nav-link">
              <i class="fa fa-circle nav-icon"></i>
              <p>
                Menu
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="" class="nav-link">
        	  <i class="fa fa-circle nav-icon"></i>
              <p>
                Chefs
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="gallery" class="nav-link">
       	     <i class="fa fa-circle nav-icon"></i> 
              <p>Gallery</p>
            </a>
          </li>

          
          <li class="nav-item">
            <a href="message-list" class="nav-link">
       	     <i class="fa fa-circle nav-icon"></i> 
              <p>Message</p>
            </a>
          </li>
		
		  <li class="nav-item">
            <a href="events-list" class="nav-link">
       	     <i class="fa fa-circle nav-icon"></i> 
              <p>Events</p>
            </a>
          </li>

		</ul>
        </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1></h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="">Home</a></li>
              <li class="breadcrumb-item active">reservation list</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
     <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Reservation list </h3>
                <div class="card-tools">
                  
                </div>
        </div>
        <!-- /.card-header -->
    <div class="card-body" >
         <table class="table table-bordered" >
          	<thead> 
          <tr>
	          <th>ID</th>
	          <th >Name</th>
	          <th >Email</th>
	          <th >Phone</th>
	          <th >Date</th>
	          <th >#People</th>
	          <th>Message</th>
	          <th >Time</th>
	          <th >Action</th>
	          </tr>
          </thead>

        <!-- /.card-body -->
    <tbody>
      		
      
      		<c:forEach var="reservation" items="${resList}" >
      	<tr>
      		<td>${reservation.id}</td>
      		<td>${reservation.name}</td>
      		<td>${reservation.email}</td>
      		<td>${reservation.phone}</td>
      		<td>${reservation.date}</td>
      		<td>${reservation.numberOfPeople}</td>
      		<td >${reservation.message}</td>
			<td>${reservation.time}</td>      		
      		
      			
      			<td class="btn-group" style="width: 100%">	
      			
      			<c:if test="${!reservation.isRead}">
      				<a href="reservation-seen?id=${reservation.id}"  style="border-color:black; background-color:aqua;" class="btn" /><i class="fa fa-eye"></i></button>
      			</c:if>
      			</span>
				<a href="delete-reservation?id=${reservation.id}"  style="border-color:black; background-color:orange;" class="btn" /><i class="fa fa-trash"></i></button>
				
      			
      		</td>  	
    
                	
                	
    	</tr>
    			 
                        
<%--          	<div class="modal fade" id="delete-modal-${reservation.id}"> --%>
<!--     		<div class="modal-dialog"> -->
<!--        		<div class="modal-content"> -->
<!--          	<div class="modal-header"> -->
<!--          	   	<h4 class="modal-title">Delete Reservation</h4> -->
<!--            	 	<button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
<!--               		<span aria-hidden="true">&times;</span> -->
<!--           	  </button> -->
<!--          	</div> -->
<!--         	<div class="modal-body"> -->
<!--          	   <p>Are you sure you want to delete reservation?</p> -->
<!--          	   <strong></strong> -->
<!--           	</div> -->
<!--           	<div class="modal-footer justify-content-between"> -->
<!--             <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button> -->
<%--             <a href="delete-reservation?id=${reservation.id}" class="btn btn-danger">Delete</a> --%>
<!--           	</div> -->
<!--         	</div> -->
<!--         /.modal-content -->
<!--       	</div> -->
<!--       	/.modal-dialog -->
<!--    		 </div> -->
          </c:forEach>  
                  </tbody>
                </table>
              </div>
    <!-- /.card -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b></b> 
    </div>
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jsGrid -->
<script src="${pageContext.request.contextPath}/plugins/jsgrid/demos/db.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jsgrid/jsgrid.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
  $(function () {
    $("#jsGrid1").jsGrid({
        height: "100%",
        width: "100%",

        sorting: true,
        paging: true,

        data: db.clients,

        fields: [
            { name: "Name", type: "text", width: 150 },
            { name: "Age", type: "number", width: 50 },
            { name: "Address", type: "text", width: 200 },
            { name: "Country", type: "select", items: db.countries, valueField: "Id", textField: "Name" },
            { name: "Married", type: "checkbox", title: "Is Married" }
        ]
    });
  });
</script>
</body>
</html>