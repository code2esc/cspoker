/**
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.common.elements.player;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Player
		implements Serializable {
	
	private static final long serialVersionUID = -452248757827187248L;
	
	@XmlAttribute
	private long id;
	
	private String name;
	
	public Player(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Player(Player player) {
		this(player.getId(), player.getName());
	}
	
	protected Player() {
	// NO OP
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + " (#" + getId() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Player))
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}