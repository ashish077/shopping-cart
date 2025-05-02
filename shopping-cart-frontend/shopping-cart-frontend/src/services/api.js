import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api'; // Adjust if your backend uses a different base path

export const fetchProducts = () => axios.get(`${API_BASE_URL}/products`);
export const fetchProductById = (id) => axios.get(`${API_BASE_URL}/products/${id}`);
export const searchProducts = (query) => axios.get(`${API_BASE_URL}/products/search`, { params: { q: query } });
export const fetchCart = (userId) => axios.get(`${API_BASE_URL}/cart/${userId}`);
export const addToCart = (userId, productId) => axios.post(`${API_BASE_URL}/cart/${userId}/add`, { productId });
export const removeFromCart = (userId, productId) => axios.post(`${API_BASE_URL}/cart/${userId}/remove`, { productId });