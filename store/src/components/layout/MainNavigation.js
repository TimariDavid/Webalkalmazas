import { Link } from 'react-router-dom'
import classes from './MainNavigation.module.css'

function MainNavigation() {
  return <header className={classes.header}>
      <nav className={classes.nav}>
          <ul className={classes.ul}>
              <li>
                <Link to='/'>Home</Link>
              </li>
              <li>
                <Link to='/phone'>Phones</Link>
              </li>
              <li>
                <Link to='/tablet'>Tablets</Link>
              </li>
          </ul>
      </nav>
  </header>;
}

export default MainNavigation;
