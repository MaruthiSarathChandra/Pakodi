// Simulate username from backend template
document.getElementById("username").textContent = "User"; // replace dynamically later

// Fetch Orders
async function fetchOrders() {
  try {
    const response = await fetch('http://localhost:8080/pakodi/past-orders', {
      method: 'GET',
      credentials: 'include',
      headers: {
        'Content-Type': 'application/json'
      }
    });
    return await response.json();
  } catch (error) {
    console.error('Error fetching orders:', error);
    return [];
  }
}


// Render Orders
const pastorders = document.getElementById("past-orders");

fetchOrders().then(data => {
  if (data && Array.isArray(data)) {
    data.forEach(order => {
      const card = document.createElement("div");
      card.classList.add("product-card");

      card.innerHTML = `
        <div class="image">
          <img src="${order.image || 'https://via.placeholder.com/300'}" alt="${order.itemName}" />
        </div>
        <div class="product-info">
          <div class="rating">4.4 ★ | 33</div>
          <div class="product-name">${order.itemName}</div>
          <div class="restaurant-name">${order.restaurantId.restaurantName}</div>
          <div class="price">
            Rs. ${Math.round(order.price * 100)}
            <span class="original-price">Rs. ${Math.round(order.price * 250)}</span>
            <span class="discount">(60% OFF)</span>
          </div>
          <div class="product-description">
            Status: <span>${capitalize(order.itemStatus)}</span>
            Type: <span>${capitalize(order.itemType)}</span>
          </div>
          <div class="product-description">Ingredients: ${order.ingredients}</div>
          <input type="number" id="quantity-${order.id}" min="1" value="1" />
          <div><button onclick="addToCart(${order.restaurantId.id}, ${order.id}, ${order.price})">Add to Cart</button></div>
        </div>
      `;

      pastorders.appendChild(card);
    });
  } else {
    pastorders.innerHTML = "No past orders found.";
  }
});

function capitalize(str) {
  return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
}


// Add to cart
async function addToCart(restaurantId, id, price) {
  const quantity = document.getElementById(`quantity-${id}`).value;

  const cartData = {
    quantity: parseInt(quantity),
    restaurant: { id: restaurantId },
    menuId: { id, price }
  };

  try {
    const response = await fetch('http://localhost:8080/pakodi/api/add-to-cart', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(cartData)
    });

    if (response.ok) {
      const result = await response.json();
      alert('Item successfully added to cart!');
      console.log(result);
    } else {
      console.error('Add to cart failed:', response.statusText);
    }
  } catch (error) {
    console.error('Error:', error);
  }
}
