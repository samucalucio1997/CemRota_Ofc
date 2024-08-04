/** @type {import('tailwindcss').Config} */
export default {
  content: [ 
    './src/**/*.{html,js,ts,jsx,tsx}',
    './node_modules/react-tailwindcss-datepicker/dist/index.esm.js'],
  theme: {
    extend: {
      colors: {
        bluePantone: '#3D6A71',
        bluePantone80: '#3D6A7180',
        bluePantone10: '#3D6A7110',
      }
    },
  },
  plugins: [],
}

