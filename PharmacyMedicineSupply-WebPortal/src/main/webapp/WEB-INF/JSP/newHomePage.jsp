<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
<style type="text/css">
.section_our_solution .row {
  align-items: center;
}

.our_solution_category {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
}
.our_solution_category .solution_cards_box {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.solution_cards_box .solution_card {
  flex: 0 50%;
  background: #fff;
  box-shadow: 0 2px 4px 0 rgba(136, 144, 195, 0.2),
    0 5px 15px 0 rgba(37, 44, 97, 0.15);
  border-radius: 15px;
  margin: 8px;
  padding: 10px 15px;
  position: relative;
  z-index: 1;
  overflow: hidden;
  min-height: 265px;
  transition: 0.7s;
}

.solution_cards_box .solution_card:hover {
  background: #309df0;
  color: #fff;
  transform: scale(1.1);
  z-index: 9;
}

.solution_cards_box .solution_card:hover::before {
  background: rgb(85 108 214 / 10%);
}

.solution_cards_box .solution_card:hover .solu_title h3,
.solution_cards_box .solution_card:hover .solu_description p {
  color: #fff;
}

.solution_cards_box .solution_card:before {
  content: "";
  position: absolute;
  background: rgb(85 108 214 / 5%);
  width: 170px;
  height: 400px;
  z-index: -1;
  transform: rotate(42deg);
  right: -56px;
  top: -23px;
  border-radius: 35px;
}

.solution_cards_box .solution_card:hover .solu_description button {
  background: #fff !important;
  color: #309df0;
}

.solution_card .so_top_icon {
}

.solution_card .solu_title h3 {
  color: #212121;
  font-size: 1.3rem;
  margin-top: 13px;
  margin-bottom: 13px;
}

.solution_card .solu_description p {
  font-size: 15px;
  margin-bottom: 15px;
}

.solution_card .solu_description button {
  border: 0;
  border-radius: 15px;
  background: linear-gradient(
    140deg,
    #42c3ca 0%,
    #42c3ca 50%,
    #42c3cac7 75%
  ) !important;
  color: #fff;
  font-weight: 500;
  font-size: 1rem;
  padding: 5px 16px;
}

.our_solution_content h1 {
  text-transform: capitalize;
  margin-bottom: 1rem;
  font-size: 2.5rem;
}
.our_solution_content p {
}

.hover_color_bubble {
  position: absolute;
  background: rgb(54 81 207 / 15%);
  width: 100rem;
  height: 100rem;
  left: 0;
  right: 0;
  z-index: -1;
  top: 16rem;
  border-radius: 50%;
  transform: rotate(-36deg);
  left: -18rem;
  transition: 0.7s;
}

.solution_cards_box .solution_card:hover .hover_color_bubble {
  top: 0rem;
}

.solution_cards_box .solution_card .so_top_icon {
  width: 60px;
  height: 60px;
  border-radius: 50%;
  background: #fff;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
}

.solution_cards_box .solution_card .so_top_icon img {
  width: 40px;
  height: 50px;
  object-fit: contain;
}

/*start media query*/
@media screen and (min-width: 320px) {
  .sol_card_top_3 {
    position: relative;
    top: 0;
  }

  .our_solution_category {
    width: 100%;
    margin: 0 auto;
  }

  .our_solution_category .solution_cards_box {
    flex: auto;
  }
}
@media only screen and (min-width: 768px) {
  .our_solution_category .solution_cards_box {
    flex: 1;
  }
}
@media only screen and (min-width: 1024px) {
  .sol_card_top_3 {
    position: relative;
    top: -3rem;
  }
  .our_solution_category {
    width: 50%;
    margin: 0 auto;
  }
}

</style>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<br><br><br><br><br>
<div class="section_our_solution">
  <div class="row">
    <div class="col-lg-12 col-md-12 col-sm-12">
      <div class="our_solution_category">
        
        <div class="solution_cards_box">

          <div class="solution_card">
            <div class="hover_color_bubble"></div>
            <div><i class="far fa-calendar-plus fa-3x"></i></i></div>
            <div class="solu_title">
              <h3>Create Schedule</h3>
            </div>
            <div class="solu_description">
              <p>
                Create a schedule for meeting doctors<br>
                 from the date you want.
              </p>
              <button type="button" class="read_more_btn">Create Schedule</button>
            </div>
          </div>
          
          
          <div class="solution_card">
            <div class="hover_color_bubble"></div>
            <div><i class="fas fa-pills fa-3x"></i></div>
            <div class="solu_title">
              <h3>View Inventory</h3>
            </div>
            <div class="solu_description">
              <p>
                View all the information regarding the<br>entire stock available in all the godowns.
              </p>
              <button type="button" class="read_more_btn">View Inventory</button>
            </div>
          </div>
          
          <div class="solution_card">
            <div class="hover_color_bubble"></div>
            <div><i class="fas fa-history fa-3x"></i></div>
            <div class="solu_title">
              <h3>View Placed Orders</h3>
            </div>
            <div class="solu_description">
              <p>
                View history of all the orders that are placed.
              </p>
              <button type="button" class="read_more_btn">View Placed Orders</button>
            </div>
          </div>
        </div>
        
        <div class="solution_cards_box sol_card_top_3">
          
          <div class="solution_card">
            <div class="hover_color_bubble"></div>
            <div><i class="fas fa-cart-plus fa-3x"></i></div>
            <div class="solu_title">
              <h3>Place Order</h3>
            </div>
            <div class="solu_description">
              <p>
                Enter the demand for the medicine you want to order.<br>
                Check the inventory before placing the order, place order according to the stock availability.
              </p>
              <button type="button" class="read_more_btn">Place Order</button>
            </div>
          </div>
          
          <div class="solution_card">
            <div class="hover_color_bubble"></div>
            <div><i class="fas fa-clipboard-list fa-3x"></i></div>
            <div class="solu_title">
              <h3>View Schedule</h3>
            </div>
            <div class="solu_description">
              <p>
                View the schedule details for meeting the doctors.
              </p>
              <button type="button" class="read_more_btn">View Schedule</button>
            </div>
          </div>

          <div class="solution_card">
            <div class="hover_color_bubble"></div>
            <div><i class="fas fa-user-check fa-3x"></i></div>
            <div class="solu_title">
              <h3>View Demand Status</h3>
            </div>
            <div class="solu_description">
              <p>
                View the status of orders, if they are approved or rejected.
              </p>
              <button type="button" class="read_more_btn">View Demand Status</button>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>
</div>


</body>
</html>