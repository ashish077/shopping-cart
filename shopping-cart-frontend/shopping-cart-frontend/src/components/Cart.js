import React, { useEffect, useState } from 'react';
import { fetchCart, removeFromCart } from '../services/api';

const Cart = ({ userId, onCartUpdate }) => {
  const [cart, setCart] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchCart(userId)
      .then(res => {
        setCart(res.data);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, [userId, onCartUpdate]);

  const handleRemove = (productId) => {
    removeFromCart(userId, productId).then(() => {
      if (onCartUpdate) onCartUpdate();
    });
  };

  if (loading) return <div>Loading cart...</div>;
  if (!cart || !cart.products || cart.products.length === 0) return <div>Your cart is empty.</div>;

  return (
    <div>
      <h2>Your Cart</h2>
      <ul>
        {cart.products.map(product => (
          <li key={product.id}>
            {product.name} - ${product.price}
            <button onClick={() => handleRemove(product.id)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Cart;