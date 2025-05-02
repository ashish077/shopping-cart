import React, { useEffect, useState } from 'react';
import { fetchProducts, addToCart } from '../services/api';

const ProductList = ({ userId, onCartUpdate }) => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchProducts()
      .then(res => {
        setProducts(res.data);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, []);

  const handleAddToCart = (productId) => {
    addToCart(userId, productId).then(() => {
      if (onCartUpdate) onCartUpdate();
    });
  };

  if (loading) return <div>Loading products...</div>;

  return (
    <div>
      <h2>Products</h2>
      <ul>
        {products.map(product => (
          <li key={product.id}>
            {product.name} - ${product.price}
            <button onClick={() => handleAddToCart(product.id)}>Add to Cart</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductList;