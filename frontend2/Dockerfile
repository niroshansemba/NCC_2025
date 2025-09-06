# Use nginx image to serve static HTML
FROM nginx:alpine

# Set working directory inside container
WORKDIR /usr/share/nginx/html

# Remove default nginx index page
RUN rm -rf ./*

# Copy your frontend files (index.html) into container
COPY . .

# Expose port 80 (nginx default)
EXPOSE 80

# Start nginx server
CMD ["nginx", "-g", "daemon off;"]