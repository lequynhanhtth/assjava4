<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
 <nav class="navbar navbar-expand-sm sticky-top header-colors ">
        <div class="col-3">
            <a class="navbar-brand" href="openIndexLogin"><img id="logo" class="d-inline-block mr-1" alt="Logo"
                    src="views/image/youtube.png"> <span>Youtubi</span></a>
        </div>
        <div class="col-6">
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <form class="form-inline my-2 my-lg-0">
                    <div class="input-group" style="width:700px;">
                        <input type="text" placeholder="What're you searching for?" aria-describedby="button-addon5"
                            class="form-control">
                        <div class="input-group-append">
                            <button id="button-addon5" type="submit" class=" btn btn-primary  button-not-shadow"
                                button-not-shaodow><i class="fa fa-search"></i></button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
        <div class="col-3">
            <div class="dropdown  float-right" >
                <button class="btn btn-outline-success " type="button" id="dropdownMenuButton" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user-circle "  style="font-size: 25px"></i> ${name}
                </button>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="userHeadServlet?actions=change_password">Change Password</a>
                    <a class="dropdown-item" href="userHeadServlet?actions=edit_profile">Edit Profile</a>
                    <a class="dropdown-item" href="LogoffServlet">Logoff</a>
                </div>
            </div>
            <a type="button" href="openFavoriteVideoIndex?id=${username.id}" class="btn btn-outline-danger float-right mr-2"><i class="fa fa-heart pr-2"
                style="font-size: 25px" value="Favorite Video"></i>Favorite Video</a>
        </div>
        
    </nav>